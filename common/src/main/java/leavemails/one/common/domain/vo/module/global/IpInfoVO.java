package leavemails.one.common.domain.vo.module.global;

import leavemails.one.common.domain.vo.BaseVO;
import lombok.Data;

/**
 * @author lostsakura
 * @date 2022-05-20 18:06
 */
@Data
public class IpInfoVO extends BaseVO {

    private String ip;

    private Float lng;

    private Float lat;

    private String address;

    private Long latestConnTime;

}
