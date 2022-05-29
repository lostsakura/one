package com.leavemails.one.task.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lostsakura
 * @date 2022-05-23 01:12
 */
@Component
@Slf4j
public class RefreshIpConnectionRecordTask {

    private final RedisTemplate redisTemplate;

    @Autowired
    public RefreshIpConnectionRecordTask(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    void run() {
        log.info("test: {}", System.currentTimeMillis());
    }
}
