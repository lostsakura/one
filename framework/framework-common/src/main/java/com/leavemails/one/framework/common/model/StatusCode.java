package com.leavemails.one.framework.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lostsakura
 * @date 2022-05-19 16:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusCode {

    private Integer code;

    private String msg;

}
