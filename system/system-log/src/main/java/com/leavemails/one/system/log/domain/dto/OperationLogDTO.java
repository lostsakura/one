package com.leavemails.one.system.log.domain.dto;

import com.leavemails.one.framework.common.domain.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lostsakura
 * @date 2022-06-02 00:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class OperationLogDTO extends BaseDTO {

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

    private Date logTime;

    private Long costTime;

    private String threadName;

    private Long threadId;

    private Boolean success;

}
