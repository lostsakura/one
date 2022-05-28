package com.leavemails.one.common.model;

import lombok.Data;

import java.util.Date;

/**
 * @author lostsakura
 * @date 2022-05-28 22:00
 */
@Data
public class LogOperationData {

    private String host;

    private Integer port;

    private String clientIp;

    private String requestUrl;

    private String httpMethod;

    private Object headers;

    private String type;

    private String method;

    private Object parameter;

    private Object responseBody;

    private Date logTime;

    private Long costTime;

    private String threadName = Thread.currentThread().getName();

    private Long threadId = Thread.currentThread().getId();

    private Boolean success = false;

}
