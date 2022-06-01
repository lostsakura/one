package com.leavemails.one.log.convert;

import com.leavemails.one.common.domain.dto.log.OperationLogDTO;
import com.leavemails.one.common.domain.vo.log.OperationLogVO;
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
