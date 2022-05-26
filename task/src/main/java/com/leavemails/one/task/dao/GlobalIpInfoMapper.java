package com.leavemails.one.task.dao;

import com.leavemails.one.common.domain.dto.module.global.GlobalIpInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 17:55
 */
@Mapper
public interface GlobalIpInfoMapper {

    /**
     * 获取所有的IP信息
     * @return
     */
    List<GlobalIpInfoDTO> selectAll();
}
