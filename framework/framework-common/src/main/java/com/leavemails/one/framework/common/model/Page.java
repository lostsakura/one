package com.leavemails.one.framework.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author lostsakura
 * @date 2022-06-01 13:13
 */
@Data
@NoArgsConstructor
public class Page<T> implements Serializable {

    private int pageNum;

    private int pageSize;

    private int size;

    private long total;

    private List<T> list;

    public Page(List<T> list) {
        this.setList(list);
        this.setSize(list.size());
    }

}
