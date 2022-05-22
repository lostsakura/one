package com.leavemails.one.module.global.service.impl;

import com.leavemails.one.module.global.dao.IpInfoMapper;
import com.leavemails.one.module.global.domain.dto.IpInfoDTO;
import com.leavemails.one.module.global.domain.vo.IpInfoVO;
import com.leavemails.one.module.global.service.GlobalService;
import com.leavemails.one.module.global.struct.IpInfoConvert;
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
        for (IpInfoDTO ipInfoDTO : ipInfoDTOS) {
            System.out.println();
        }
        List<IpInfoVO> ipInfoVOS = IpInfoConvert.INSTANCE.ipInfoDTOS2IpInfoVOS(ipInfoDTOS);
        return Result.success(ipInfoVOS);
    }
}
