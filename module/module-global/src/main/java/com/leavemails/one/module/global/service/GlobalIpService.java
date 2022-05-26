package com.leavemails.one.module.global.service;

import com.leavemails.one.common.domain.vo.module.global.GlobalIpInfoVO;
import com.leavemails.one.common.model.Result;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 18:09
 */
public interface GlobalIpService {

    /**
     * 查询所有IP信息
     *
     * @return globalIpInfoList
     */
    Result<List<GlobalIpInfoVO>> list();
}