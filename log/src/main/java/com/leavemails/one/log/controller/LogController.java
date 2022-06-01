package com.leavemails.one.log.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.leavemails.one.common.domain.query.log.OperationLogQuery;
import com.leavemails.one.common.domain.vo.log.OperationLogVO;
import com.leavemails.one.common.model.Page;
import com.leavemails.one.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lostsakura
 * @date 2022-06-01 13:11
 */
@RequestMapping("/log")
@RestController
public class LogController {

    private final ElasticsearchClient elasticsearchClient;

    @Autowired
    public LogController(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @GetMapping("")
    public Result<Page<OperationLogVO>> list(@RequestParam OperationLogQuery query) {

        return null;
    }
}
