package com.leavemails.framework.web.aspect;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import com.leavemails.framework.web.annotation.OperationLog;
import com.leavemails.framework.web.model.LogOperationData;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 操作日志切面
 * 基本上借鉴了开源的aop-log实现
 * https://github.com/EalenXie/aop-log
 *
 * @author lostsakura
 * @date 2022-05-24 10:18
 */
@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    private static final String AND_REG = "&";
    private static final String EQUALS_REG = "=";

//    private final KafkaTemplate kafkaTemplate;
//
//    @Autowired
//    public OperationLogAspect(KafkaTemplate kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    @Pointcut("@annotation(com.leavemails.framework.web.annotation.OperationLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        LogOperationData data = new LogOperationData();
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            OperationLog operationLog = signature.getMethod().getAnnotation(OperationLog.class);
            if (operationLog == null) {
                operationLog = joinPoint.getTarget().getClass().getAnnotation(OperationLog.class);
            }
            logHttpRequest(data, operationLog);
            data.setType(operationLog.type().getType());
            data.setMethod(StrUtil.format("{}#{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName()));

            if (operationLog.parameter()) {
                String[] parameterNames = signature.getParameterNames();
                Object[] args = joinPoint.getArgs();
                Object target;
                if (args.length == 1) {
                    target = args[0];
                } else {
                    target = args;
                }
                if (target != null) {
                    HttpServletRequest request = getRequest();
                    if (request != null && StrUtil.isNotEmpty(request.getContentType())) {
                        String requestContentType = request.getContentType();
                        if (StrUtil.equals(requestContentType, MediaType.APPLICATION_JSON_VALUE)) {
                            data.setParameter(JSONUtil.toJsonStr(target));
                        }
                    }
                    if (data.getParameter() == null) {
                        data.setParameter(JSONUtil.toJsonStr(spliceParameters(parameterNames, args)));
                    }
                }
            }
            Object proceed = joinPoint.proceed();
            if (operationLog.responseBody()) {
                data.setResponseBody(JSONUtil.toJsonStr(proceed));
            }
            data.setSuccess(true);
            return proceed;
        } finally {
            data.cost();
            String dataStr = JSONUtil.toJsonStr(data);
            log.info(dataStr);
//            try {
//                kafkaTemplate.send(GlobalMessageConstants.OPERATION_LOG_TOPIC, dataStr);
//            } catch (Exception e) {
//                log.error("Kafka logging exception.", e);
//            }
        }
    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getRequest();
        }
        return null;
    }

    public HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getResponse();
        }
        return null;
    }

    public void logHttpRequest(LogOperationData data, OperationLog operationLog) {
        HttpServletRequest request = getRequest();
        data.setHost(request.getLocalAddr());
        data.setPort(request.getLocalPort());
        data.setClientIp(ServletUtil.getClientIP(request));
        data.setRequestUrl(request.getRequestURL().toString());
        data.setHttpMethod(request.getMethod());
        if (operationLog.headers().length > 0) {
            HashMap<String, String> headerMap = new HashMap<>(16);
            for (String header : operationLog.headers()) {
                String value = request.getHeader(header);
                if (StrUtil.isNotEmpty(value)) {
                    headerMap.put(header, value);
                }
            }
            data.setHeaders(JSONUtil.toJsonStr(headerMap));
        }
    }

    public Object spliceParameters(String[] parameterNames, Object[] args) {
        if (parameterNames == null || parameterNames.length == 0 || args == null || args.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameterNames.length; i++) {
            sb.append(parameterNames[i]).append(EQUALS_REG).append(args[i].toString()).append(AND_REG);
        }
        if (sb.lastIndexOf(AND_REG) != -1) {
            sb.deleteCharAt(sb.lastIndexOf(AND_REG));
        }
        return sb.toString();
    }

}

