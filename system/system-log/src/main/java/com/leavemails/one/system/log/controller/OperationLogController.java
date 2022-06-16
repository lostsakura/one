package com.leavemails.one.system.log.controller;

import com.leavemails.one.framework.common.model.Page;
import com.leavemails.one.framework.common.model.Result;
import com.leavemails.one.system.log.domain.query.OperationLogQuery;
import com.leavemails.one.system.log.domain.vo.OperationLogVO;
import com.leavemails.one.system.log.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author lostsakura
 * @date 2022-06-01 13:11
 */
@RequestMapping("/operation")
@RestController
public class OperationLogController {

    private final OperationService operationService;

    @Autowired
    public OperationLogController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("")
    public Result<Page<OperationLogVO>> list(OperationLogQuery query) throws IOException {
        return operationService.list(query);
    }

}
