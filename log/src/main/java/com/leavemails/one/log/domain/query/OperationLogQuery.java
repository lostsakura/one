package com.leavemails.one.log.domain.query;

import com.leavemails.one.common.constants.CommonConstants;
import com.leavemails.one.common.domain.query.BaseQuery;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lostsakura
 * @date 2022-06-01 13:33
 */
@Data
@NoArgsConstructor
public class OperationLogQuery extends BaseQuery {

    @DateTimeFormat(pattern = CommonConstants.DATE_TIME_FORMAT)
    private Date logStartTime;

    @DateTimeFormat(pattern = CommonConstants.DATE_TIME_FORMAT)
    private Date logEndTime;

    private String clientIp;

    private String type;

    private Boolean success;

    private Long minCostTime;

    private Long maxCostTime;

}
