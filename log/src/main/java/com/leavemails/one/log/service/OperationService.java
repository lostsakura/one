package com.leavemails.one.log.service;

import com.leavemails.one.common.domain.query.log.OperationLogQuery;
import com.leavemails.one.common.domain.vo.log.OperationLogVO;
import com.leavemails.one.common.model.Page;
import com.leavemails.one.common.model.Result;

import java.io.IOException;

/**
 * @author lostsakura
 * @date 2022-06-02 00:00
 */
public interface OperationService {

    /**
     * 操作日志列表查询
     * @param query
     * @return
     */
    Result<Page<OperationLogVO>> list(OperationLogQuery query) throws IOException;
}
