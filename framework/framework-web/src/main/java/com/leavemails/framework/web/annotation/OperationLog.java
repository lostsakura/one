package com.leavemails.framework.web.annotation;

import com.leavemails.framework.web.enums.LogOperationEnums;
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
