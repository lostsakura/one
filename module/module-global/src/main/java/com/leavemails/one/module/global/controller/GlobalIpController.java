package com.leavemails.one.module.global.controller;

import com.leavemails.one.common.annotation.OperationLog;
import com.leavemails.one.common.domain.query.module.global.GlobalIpQuery;
import com.leavemails.one.common.domain.vo.module.global.GlobalIpInfoVO;
import com.leavemails.one.module.global.service.GlobalIpService;
import com.leavemails.one.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 17:44
 */
@RequestMapping("global")
@RestController
public class GlobalIpController {

    private final GlobalIpService globalIpService;

    @Autowired
    public GlobalIpController(GlobalIpService globalIpService) {
        this.globalIpService = globalIpService;
    }

    @OperationLog
    @PostMapping("")
    public Result<List<GlobalIpInfoVO>> list(@RequestBody GlobalIpQuery query) {
        return globalIpService.list();
    }

}
