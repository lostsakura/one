package leavemails.one.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lostsakura
 * @date 2022-05-19 16:11
 */
@Data
@AllArgsConstructor
public class StatusCode {

    private Integer code;

    private String msg;

}
