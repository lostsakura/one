package com.leavemails.one.module.global.controller;

import com.github.AopLog;
import com.leavemails.one.common.annotation.OperationLog;
import com.leavemails.one.common.domain.vo.module.global.GlobalIpInfoVO;
import com.leavemails.one.common.enums.LogOperationEnums;
import com.leavemails.one.common.model.Result;
import com.leavemails.one.module.global.service.GlobalIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 17:44
 */
@RequestMapping("/global/ip")
@RestController
public class GlobalIpController {

    private final GlobalIpService globalIpService;

    @Autowired
    public GlobalIpController(GlobalIpService globalIpService) {
        this.globalIpService = globalIpService;
    }

    @AopLog
    @OperationLog(type = LogOperationEnums.QUERY)
    @GetMapping("")
    public Result<List<GlobalIpInfoVO>> list() {
        return globalIpService.list();
    }

}
