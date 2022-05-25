package com.leavemails.one.module.global.service.impl;

import cn.hutool.json.JSONUtil;
import com.leavemails.one.module.global.service.GlobalService;
import com.leavemails.one.common.domain.vo.module.global.IpInfoVO;
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
public class GlobalServiceImpl implements GlobalService {

    private final RedisTemplate redisTemplate;

    @Autowired
    public GlobalServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Result<List<IpInfoVO>> list() {
        List<IpInfoVO> ipInfoVOS = new ArrayList<>();
        Object cache = redisTemplate.opsForValue().get("ONE:GLOBAL:IP-LIST");
        if (cache != null) {
            ipInfoVOS = JSONUtil.parseArray(cache).toList(IpInfoVO.class);
        }
        return Result.success(ipInfoVOS);
    }
}
