package com.leavemails.one.task.task;

import cn.hutool.core.date.DateUtil;
import com.leavemails.one.task.dao.IpInfoMapper;
import leavemails.one.common.domain.dto.module.global.IpInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lostsakura
 * @date 2022-05-23 01:12
 */
@Component
@Slf4j
public class RefreshIpConnectionRecordTask {

    private final RedisTemplate redisTemplate;
    private final IpInfoMapper ipInfoMapper;

    @Autowired
    public RefreshIpConnectionRecordTask(RedisTemplate redisTemplate, IpInfoMapper ipInfoMapper) {
        this.redisTemplate = redisTemplate;
        this.ipInfoMapper = ipInfoMapper;
    }

    void run() {
        List<IpInfoDTO> ipInfoDTOS = ipInfoMapper.selectAll();
        redisTemplate.opsForValue().set("ONE:GLOBAL:IP-LIST", ipInfoDTOS, 10, TimeUnit.SECONDS);
        log.info("IP同步完成 - {}", DateUtil.now());
    }
}
