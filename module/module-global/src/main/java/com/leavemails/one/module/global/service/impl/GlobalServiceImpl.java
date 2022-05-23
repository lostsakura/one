package com.leavemails.one.module.global.service.impl;

import com.leavemails.one.module.global.dao.IpInfoMapper;
import com.leavemails.one.module.global.domain.dto.IpInfoDTO;
import com.leavemails.one.module.global.domain.vo.IpInfoVO;
import com.leavemails.one.module.global.service.GlobalService;
import com.leavemails.one.module.global.struct.IpInfoConvert;
import leavemails.one.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 18:09
 */
@RefreshScope
@Slf4j
@Service
public class GlobalServiceImpl implements GlobalService {

    private final IpInfoMapper ipInfoMapper;
    private final RedisTemplate redisTemplate;

    @Autowired
    public GlobalServiceImpl(IpInfoMapper ipInfoMapper, RedisTemplate redisTemplate) {
        this.ipInfoMapper = ipInfoMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Result<List<IpInfoVO>> list() {
        List<IpInfoDTO> ipInfoDTOS = ipInfoMapper.selectAll();
        List<IpInfoVO> ipInfoVOS = IpInfoConvert.INSTANCE.ipInfoDTOS2IpInfoVOS(ipInfoDTOS);
        return Result.success(ipInfoVOS);
    }
}
