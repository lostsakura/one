package com.leavemails.one.common.constants;

import com.leavemails.one.common.model.LogOperation;

/**
 * @author lostsakura
 * @date 2022-05-28 21:44
 */
public interface LogOperationConstants {

    LogOperation UNDEFINED = new LogOperation("undefined", "未定义");
    LogOperation INSERT = new LogOperation("insert", "新增");
    LogOperation UPDATE = new LogOperation("update", "更新");
    LogOperation DELETE = new LogOperation("delete", "删除");
    LogOperation OTHER = new LogOperation("other", "其他");
}
