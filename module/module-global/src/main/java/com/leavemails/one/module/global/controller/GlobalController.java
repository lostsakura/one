package com.leavemails.one.module.global.controller;

import leavemails.one.common.domain.vo.module.global.IpInfoVO;
import com.leavemails.one.module.global.service.GlobalService;
import leavemails.one.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 17:44
 */
@RequestMapping("global")
@RestController
public class GlobalController {

    private final GlobalService globalService;

    @Autowired
    public GlobalController(GlobalService globalService) {
        this.globalService = globalService;
    }

    @GetMapping("")
    public Result<List<IpInfoVO>> list() {
        return globalService.list();
    }

}
