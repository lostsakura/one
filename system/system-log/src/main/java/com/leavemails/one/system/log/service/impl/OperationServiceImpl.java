package com.leavemails.one.system.log.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.leavemails.one.framework.common.constants.GlobalIndexConstants;
import com.leavemails.one.framework.common.model.Page;
import com.leavemails.one.framework.common.model.Result;
import com.leavemails.one.system.log.convert.OperationLogConvert;
import com.leavemails.one.system.log.domain.dto.OperationLogDTO;
import com.leavemails.one.system.log.domain.query.OperationLogQuery;
import com.leavemails.one.system.log.domain.vo.OperationLogVO;
import com.leavemails.one.system.log.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lostsakura
 * @date 2022-06-02 00:01
 */
@Service
public class OperationServiceImpl implements OperationService {

    private final ElasticsearchClient elasticsearchClient;

    @Autowired
    public OperationServiceImpl(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }


    @Override
    public Result<Page<OperationLogVO>> list(OperationLogQuery query) throws IOException {
        SearchResponse<OperationLogDTO> search = elasticsearchClient
                .search(
                        r -> r
                                .index(GlobalIndexConstants.OPERATION_LOG_INDEX)
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
                                .size(20)
                        , OperationLogDTO.class
                );
        List<OperationLogDTO> collect = search.hits().hits().stream().map(Hit::source).collect(Collectors.toList());
        List<OperationLogVO> operationLogVOS = OperationLogConvert.INSTANCE.operationLogDTOS2operationLogVOS(collect);
        Page<OperationLogVO> result = new Page<>(operationLogVOS);
        return Result.success(result);
    }
}
