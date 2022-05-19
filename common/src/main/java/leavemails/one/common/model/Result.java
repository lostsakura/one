package leavemails.one.common.model;

import java.io.Serializable;

/**
 * @author lostsakura
 * @date 2022-05-19 16:14
 */
public class Result<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

}
