package com.leavemails.one.common.domain.vo.log;

import com.leavemails.one.common.domain.vo.BaseVO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lostsakura
 * @date 2022-06-01 13:24
 */
@Data
@NoArgsConstructor
public class OperationLogVO extends BaseVO {

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
