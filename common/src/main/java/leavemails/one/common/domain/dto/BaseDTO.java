package leavemails.one.common.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author lostsakura
 * @date 2022-05-20 18:15
 */
@Getter
@Setter
@ToString
public class BaseDTO {

    private Long id;

    private Date insertTime;

    private Date updateTime;
}