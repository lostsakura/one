package com.leavemails.one.module.global.domain.query;

import com.leavemails.one.framework.common.domain.query.BaseQuery;
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
