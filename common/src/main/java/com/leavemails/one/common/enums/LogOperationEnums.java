package com.leavemails.one.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lostsakura
 * @date 2022-05-29 17:55
 */
@Getter
@AllArgsConstructor
public enum LogOperationEnums {

    // 未定义
    UNDEFINED("undefined"),
    // 查询
    QUERY("query"),
    // 新增
    INSERT("insert"),
    // 更新
    UPDATE("update"),
    // 删除
    DELETE("delete"),
    // 其他
    OTHER("other"),
    ;

    private String type;

}
