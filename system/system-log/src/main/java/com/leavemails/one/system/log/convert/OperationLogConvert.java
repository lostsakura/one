package com.leavemails.one.system.log.convert;

import com.leavemails.one.system.log.domain.dto.OperationLogDTO;
import com.leavemails.one.system.log.domain.vo.OperationLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author lostsakura
 * @date 2022-06-02 00:18
 */
@Mapper
public interface OperationLogConvert {

    OperationLogConvert INSTANCE = Mappers.getMapper(OperationLogConvert.class);

    @Mappings({
            @Mapping(target = "logTime", expression = "java(operationLogDTO.getLogTime().getTime())")
    })
    OperationLogVO operationLogDTO2operationLogVO(OperationLogDTO operationLogDTO);

    List<OperationLogVO> operationLogDTOS2operationLogVOS(List<OperationLogDTO> operationLogDTOS);

}
