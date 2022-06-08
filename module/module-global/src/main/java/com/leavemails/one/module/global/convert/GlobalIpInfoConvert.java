package com.leavemails.one.module.global.convert;

import com.leavemails.one.module.global.domain.dto.GlobalIpInfoDTO;
import com.leavemails.one.module.global.domain.vo.GlobalIpInfoVO;
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
