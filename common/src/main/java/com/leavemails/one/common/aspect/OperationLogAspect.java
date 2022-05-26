package com.leavemails.one.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
public class OperationLogAspect {

    @Pointcut("@annotation(com.leavemails.one.common.annotation.OperationLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        log.trace("annotation trace {}", System.currentTimeMillis());
        log.debug("annotation debug {}", System.currentTimeMillis());
        log.info("annotation info {}", System.currentTimeMillis());
        log.warn("annotation warn {}", System.currentTimeMillis());
        log.error("annotation error {}", System.currentTimeMillis());
        return joinPoint.proceed();
    }

}

