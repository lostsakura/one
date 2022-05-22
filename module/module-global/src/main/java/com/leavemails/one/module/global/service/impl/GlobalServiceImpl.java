package com.leavemails.one.module.global.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.leavemails.one.module.global.dao.IpInfoMapper;
import com.leavemails.one.module.global.domain.dto.IpInfoDTO;
import com.leavemails.one.module.global.domain.vo.IpInfoVO;
import com.leavemails.one.module.global.service.GlobalService;
import leavemails.one.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 18:09
 */
@Service
public class GlobalServiceImpl implements GlobalService {

    private final IpInfoMapper ipInfoMapper;

    @Autowired
    public GlobalServiceImpl(IpInfoMapper ipInfoMapper) {
        this.ipInfoMapper = ipInfoMapper;
    }

    @Override
    public Result<List<IpInfoVO>> list() {
        List<IpInfoDTO> ipInfoDTOS = ipInfoMapper.selectAll();
        List<IpInfoVO> ipInfoVOS = BeanUtil.copyToList(ipInfoDTOS, IpInfoVO.class);
        return Result.success(ipInfoVOS);
    }
}
