package com.leavemails.one.common.domain.dto.module.global;

import com.leavemails.one.common.domain.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author lostsakura
 * @date 2022-05-20 17:53
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalIpInfoDTO extends BaseDTO {

    private Long id;

    private String ip;

    private Float lng;

    private Float lat;

    private String address;

    private Date latestConnTime;

    private Date insertTime;

    private Date updateTime;

}