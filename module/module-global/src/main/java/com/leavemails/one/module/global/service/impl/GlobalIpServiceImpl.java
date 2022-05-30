package com.leavemails.one.module.global.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import com.leavemails.one.common.domain.dto.module.global.GlobalIpInfoDTO;
import com.leavemails.one.common.domain.vo.module.global.GlobalIpInfoVO;
import com.leavemails.one.common.model.Result;
import com.leavemails.one.module.global.convert.GlobalIpInfoConvert;
import com.leavemails.one.module.global.dao.GlobalIpInfoMapper;
import com.leavemails.one.module.global.service.GlobalIpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lostsakura
 * @date 2022-05-20 18:09
 */
@Slf4j
@Service
public class GlobalIpServiceImpl implements GlobalIpService {

    private final String IP_LIST_CACHE_MARK = "ONE:GLOBAL:IP-LIST";

    private final RedisTemplate redisTemplate;
    private final GlobalIpInfoMapper globalIpInfoMapper;

    @Autowired
    public GlobalIpServiceImpl(RedisTemplate redisTemplate, GlobalIpInfoMapper globalIpInfoMapper) {
        this.redisTemplate = redisTemplate;
        this.globalIpInfoMapper = globalIpInfoMapper;
    }

    @Override
    public Result<List<GlobalIpInfoVO>> list(HttpServletRequest request) {
        String clientIp = ServletUtil.getClientIP(request);
        List<GlobalIpInfoVO> globalIpInfoVOS = new ArrayList<>();
        Object cache = redisTemplate.opsForValue().get(IP_LIST_CACHE_MARK);
        if (cache != null) {
            globalIpInfoVOS = JSONUtil.parseArray(cache).toList(GlobalIpInfoVO.class);
        }
        if (StrUtil.isNotEmpty(clientIp)) {
            Date now = new Date();
            AtomicBoolean isExist = new AtomicBoolean(false);
            globalIpInfoVOS
                    .stream()
                    .filter(o -> StrUtil.equals(o.getIp(), clientIp))
                    .findFirst().ifPresent(o -> {
                        o.setLatestConnTime(now.getTime());
                        isExist.set(true);
                    });
            GlobalIpInfoDTO globalIpInfoDTO = new GlobalIpInfoDTO();
            globalIpInfoDTO.setIp(clientIp);
            globalIpInfoDTO.setLatestConnTime(now);
            if (isExist.get()) {
                globalIpInfoMapper.updateGlobalIpInfoByIp(globalIpInfoDTO);
            } else {
                globalIpInfoMapper.insertGlobalIpInfo(globalIpInfoDTO);
                globalIpInfoVOS.add(GlobalIpInfoConvert.INSTANCE.ipInfoDTO2IpInfoVO(globalIpInfoDTO));
            }
            redisTemplate.opsForValue().set(IP_LIST_CACHE_MARK, globalIpInfoVOS);
        }
        return Result.success(globalIpInfoVOS);
    }
}
