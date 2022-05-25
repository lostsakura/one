package com.leavemails.one.common.aspect;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lostsakura
 * @date 2022-05-24 10:18
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {

    @Pointcut("@annotation(com.leavemails.one.common.annotation.SysLog)")
    public void logPointCut() {
    }

    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint, null, jsonResult);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        System.out.println(StrUtil.toString(jsonResult));
        log.info(StrUtil.toString(jsonResult));
    }

}

