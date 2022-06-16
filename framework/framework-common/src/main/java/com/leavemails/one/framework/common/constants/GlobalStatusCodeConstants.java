package com.leavemails.one.framework.common.constants;

import com.leavemails.one.framework.common.model.StatusCode;

/**
 * @author lostsakura
 * @date 2022-05-19 19:30
 */
public interface GlobalStatusCodeConstants {

    StatusCode SUCCESS = new StatusCode(200, "成功");

    StatusCode SYSTEM_ERROR = new StatusCode(500, "系统错误");

}
