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

    private String headers;

    private String type;

    private String method;

    private String parameter;

    private String responseBody;

    private Date logTime = new Date();

    private Long costTime;

    private String threadName = Thread.currentThread().getName();

    private Long threadId = Thread.currentThread().getId();

    private Boolean success = false;

    public void cost() {
        this.setCostTime(System.currentTimeMillis() - this.getLogTime().getTime());
    }

}
