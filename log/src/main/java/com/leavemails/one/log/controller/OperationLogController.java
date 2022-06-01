package com.leavemails.one.log.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.leavemails.one.common.domain.query.log.OperationLogQuery;
import com.leavemails.one.common.domain.vo.log.OperationLogVO;
import com.leavemails.one.common.model.Page;
import com.leavemails.one.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lostsakura
 * @date 2022-06-01 13:11
 */
@RequestMapping("/operation")
@RestController
public class OperationLogController {

    private final ElasticsearchClient elasticsearchClient;

    @Autowired
    public OperationLogController(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @GetMapping("")
    public Result<Page<OperationLogVO>> list(OperationLogQuery query) throws IOException {
        SearchResponse<OperationLogVO> search = elasticsearchClient
                .search(
                        r -> r
                                .index("operation-log-*")
                                .query(q -> q
                                        .bool(b -> b
                                                .must(m -> m
                                                        .term(t -> t
                                                                .field("clientIp")
                                                                .value(query.getClientIp())
                                                        )
                                                )
                                                .must(m -> m
                                                        .term(t -> t
                                                                .field("type")
                                                                .value(query.getType())
                                                        )
                                                )
                                                .must(m -> m
                                                        .term(t -> t
                                                                .field("success")
                                                                .value(query.getSuccess())
                                                        )
                                                )
                                                .filter(
                                                        l -> l
                                                                .range(
                                                                        g -> g
                                                                                .field("logTime")
                                                                                .gte(JsonData.of(query.getLogStartTime()))
                                                                                .lte(JsonData.of(query.getLogEndTime()))
                                                                )
                                                )
                                                .filter(c -> c
                                                        .range(
                                                                e -> e
                                                                        .field("costTime")
                                                                        .gte(JsonData.of(query.getMinCostTime()))
                                                                        .lte(JsonData.of(query.getMaxCostTime()))
                                                        )
                                                )
                                        )
                                )
                                .sort(s -> s
                                        .field(f -> f
                                                .field("logTime")
                                                .order(SortOrder.Desc)
                                        )
                                )
                        , OperationLogVO.class
                );
        List<OperationLogVO> collect = search.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
        Page<OperationLogVO> result = new Page<>();
        result.setList(collect);
        return Result.success(result);
    }
}
