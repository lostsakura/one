package com.leavemails.framework.aop.annotation;

import com.leavemails.framework.aop.enums.LogOperationEnums;
import org.springframework.http.HttpHeaders;

import java.lang.annotation.*;

/**
 * @author lostsakura
 * @date 2022-05-24 09:17
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {

    LogOperationEnums type() default LogOperationEnums.UNDEFINED;

    String[] headers() default {HttpHeaders.USER_AGENT, HttpHeaders.CONTENT_TYPE};

    boolean parameter() default true;

    boolean responseBody() default true;

}
