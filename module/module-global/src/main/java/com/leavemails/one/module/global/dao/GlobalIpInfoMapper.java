package com.leavemails.one.module.global.dao;

import com.leavemails.one.module.global.domain.dto.GlobalIpInfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-20 17:55
 */
@Mapper
public interface GlobalIpInfoMapper {

    /**
     * 新增IP信息
     *
     * @param dto
     * @return
     */
    int insertGlobalIpInfo(GlobalIpInfoDTO dto);

    /**
     * 通过IP更新IP信息
     *
     * @param dto
     * @return
     */
    int updateGlobalIpInfoByIp(GlobalIpInfoDTO dto);

    /**
     * 获取所有的IP信息
     *
     * @return
     */
    List<GlobalIpInfoDTO> selectAll();

}
