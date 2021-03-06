package com.leavemails.one.framework.common.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lostsakura
 * @date 2022-05-20 18:15
 */
@Data
public class BaseDTO implements Serializable {

    private Long id;

    private Date insertTime;

    private Date updateTime;
}
