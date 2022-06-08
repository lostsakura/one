package com.leavemails.one.module.global.domain.vo;

import com.leavemails.one.common.domain.vo.BaseVO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lostsakura
 * @date 2022-05-20 18:06
 */
@Data
@NoArgsConstructor
public class GlobalIpInfoVO extends BaseVO {

    private String ip;

    private Float lng;

    private Float lat;

    private String address;

    private Long latestConnTime;

}
