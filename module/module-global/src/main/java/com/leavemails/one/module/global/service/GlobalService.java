package com.leavemails.one.module.global.service;

import com.leavemails.one.common.domain.vo.module.global.IpInfoVO;
import com.leavemails.one.common.model.Result;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 18:09
 */
public interface GlobalService {

    /**
     * 查询所有IP信息
     *
     * @return ipInfoList
     */
    Result<List<IpInfoVO>> list();
}
