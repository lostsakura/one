package com.leavemails.one.module.global.domain.vo;

import lombok.Data;

/**
 * @author lostsakura
 * @date 2022-05-20 18:06
 */
@Data
public class IpInfoVO {

    private String ip;

    private Float lng;

    private Float lat;

    private String address;

    private Long latestConnTime;

}