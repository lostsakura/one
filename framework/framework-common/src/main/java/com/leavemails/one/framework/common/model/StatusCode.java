package com.leavemails.one.framework.common.model;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * @author lostsakura
 * @date 2022-05-19 16:11
 */
@Data
public class StatusCode {

    private Integer code;

    private String msg;

    public StatusCode(Integer code) {
        this.code = code;
        this.msg = "";
    }

    public StatusCode(Integer code, String msg) {
        this.code = code;
        if (StrUtil.isEmpty(msg)) {
            this.msg = "";
        } else {
            this.msg = msg;
        }
    }
}
