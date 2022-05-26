package com.leavemails.one.common.domain.query.module.global;

import com.leavemails.one.common.domain.query.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lostsakura
 * @date 2022-05-26 18:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalIpQuery extends BaseQuery {

    private String key;

    private String value;

}
