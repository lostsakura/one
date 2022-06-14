package com.leavemails.one.module.global.controller;

import com.leavemails.framework.aop.annotation.OperationLog;
import com.leavemails.framework.aop.enums.LogOperationEnums;
import com.leavemails.one.framework.common.model.Result;
import com.leavemails.one.module.global.domain.vo.GlobalIpInfoVO;
import com.leavemails.one.module.global.service.GlobalIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @OperationLog(type = LogOperationEnums.QUERY)
    @GetMapping("")
    public Result<List<GlobalIpInfoVO>> list(HttpServletRequest request) {
        return globalIpService.list(request);
    }

}
