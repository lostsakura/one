package com.leavemails.one.common.convert;

import com.leavemails.one.common.domain.dto.module.global.GlobalIpInfoDTO;
import com.leavemails.one.common.domain.vo.module.global.GlobalIpInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-05-22 23:56
 */
@Mapper
public interface GlobalIpInfoConvert {

    GlobalIpInfoConvert INSTANCE = Mappers.getMapper(GlobalIpInfoConvert.class);

    @Mappings({
            @Mapping(target = "latestConnTime", expression = "java(globalIpInfoDTO.getLatestConnTime().getTime())")
    })
    GlobalIpInfoVO ipInfoDTO2IpInfoVO(GlobalIpInfoDTO globalIpInfoDTO);

    List<GlobalIpInfoVO> ipInfoDTOS2IpInfoVOS(List<GlobalIpInfoDTO> globalIpInfoDTOS);

}
