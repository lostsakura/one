package com.leavemails.one.framework.common.model;

import cn.hutool.core.lang.Assert;
import com.leavemails.one.framework.common.constants.GlobalStatusCodeConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lostsakura
 * @date 2022-05-19 16:14
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = GlobalStatusCodeConstants.SUCCESS.getCode();
        result.msg = "";
        return result;
    }

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

    public static <T> Result<T> error(StatusCode statusCode) {
        Assert.isTrue(!GlobalStatusCodeConstants.SUCCESS.getCode().equals(statusCode.getCode()), "仅能设置为错误的code");
        Result<T> result = new Result<>();
        result.code = statusCode.getCode();
        result.msg = statusCode.getMsg();
        return result;
    }


}
