package com.leavemails.one.common.model;

import cn.hutool.core.lang.Assert;
import com.leavemails.one.common.constants.GlobalStatusCodeConstants;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lostsakura
 * @date 2022-05-19 16:14
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = GlobalStatusCodeConstants.SUCCESS.getCode();
        result.msg = "";
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(Integer code, String message) {
        Assert.isTrue(!GlobalStatusCodeConstants.SUCCESS.getCode().equals(code), "仅能设置为错误的code");
        Result<T> result = new Result<>();
        result.code = code;
        result.msg = message;
        return result;
    }


}
