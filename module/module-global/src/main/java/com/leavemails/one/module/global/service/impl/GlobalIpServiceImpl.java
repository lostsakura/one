package com.leavemails.one.module.global.service.impl;

import cn.hutool.json.JSONUtil;
import com.leavemails.one.module.global.service.GlobalIpService;
import com.leavemails.one.common.domain.vo.module.global.GlobalIpInfoVO;
import com.leavemails.one.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 18:09
 */
@RefreshScope
@Slf4j
@Service
public class GlobalIpServiceImpl implements GlobalIpService {

    private final RedisTemplate redisTemplate;

    @Autowired
    public GlobalIpServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Result<List<GlobalIpInfoVO>> list() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        List<GlobalIpInfoVO> globalIpInfoVOS = new ArrayList<>();
        Object cache = redisTemplate.opsForValue().get("ONE:GLOBAL:IP-LIST");
        if (cache != null) {
            globalIpInfoVOS = JSONUtil.parseArray(cache).toList(GlobalIpInfoVO.class);
        }
        return Result.success(globalIpInfoVOS);
    }
}
