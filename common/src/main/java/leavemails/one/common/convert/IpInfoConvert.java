package leavemails.one.common.convert;

import leavemails.one.common.domain.dto.module.global.IpInfoDTO;
import leavemails.one.common.domain.vo.module.global.IpInfoVO;
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
public interface IpInfoConvert {

    IpInfoConvert INSTANCE = Mappers.getMapper(IpInfoConvert.class);

    @Mappings({
            @Mapping(target = "latestConnTime", expression = "java(ipInfoDTO.getLatestConnTime().getTime())")
    })
    IpInfoVO ipInfoDTO2IpInfoVO(IpInfoDTO ipInfoDTO);

    List<IpInfoVO> ipInfoDTOS2IpInfoVOS(List<IpInfoDTO> ipInfoDTOS);

}
