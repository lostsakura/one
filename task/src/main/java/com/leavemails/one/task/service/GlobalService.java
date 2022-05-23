package com.leavemails.one.task.service;

import leavemails.one.common.domain.vo.module.global.IpInfoVO;
import leavemails.one.common.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-24 00:00
 */
@FeignClient(name = "one-global")
public interface GlobalService {

    @GetMapping("/global")
    Result<List<IpInfoVO>> list();

}
