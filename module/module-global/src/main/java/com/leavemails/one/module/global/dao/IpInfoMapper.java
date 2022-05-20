package com.leavemails.one.module.global.dao;

import com.leavemails.one.module.global.domain.dto.IpInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 17:55
 */
@Mapper
public interface IpInfoMapper {

    /**
     * 获取所有的IP信息
     * @return
     */
    List<IpInfoDTO> selectAll();
}
