package com.leavemails.one.framework.web.handler;

import com.leavemails.one.framework.common.constants.GlobalStatusCodeConstants;
import com.leavemails.one.framework.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lostsakura
 * @date 2022-06-16 10:55
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    Result<Object> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(GlobalStatusCodeConstants.SYSTEM_ERROR);
    }

}
