package com.leeyumo.elasticsearchJava.service.impl;

import com.alibaba.fastjson.JSON;
import com.leeyumo.elasticsearchJava.domain.constant.VehicleBrand;
import com.leeyumo.elasticsearchJava.domain.indexName.IndexName;
import com.leeyumo.elasticsearchJava.service.HighLevelRestClientTemplate;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HighLevelRestClientTemplateImpl implements HighLevelRestClientTemplate {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 根据索引名，id，具体内容进行插入和更新，类似JPA中的save方法
     * @param indexName
     * @param id
     * @param source
     * @return
     * @throws IOException
     */
    @Override
    public boolean createByIndexAndId(IndexName indexName, String id, Object source) throws IOException {
        IndexRequest request = new IndexRequest(indexName.stringValue());
        request.id(id);
        request.source(JSON.toJSONString(source), XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
            return true;
        } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            return true;
        }
        return false;
    }

    @Override
    public Object getSource(IndexName indexName) throws IOException {
        SearchRequest searchRequest = new SearchRequest(indexName.stringValue());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("brand", VehicleBrand.DasAuto.name()));
//        searchSourceBuilder.from(0);
//        searchSourceBuilder.size(2);
//        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("brand", VehicleBrand.DasAuto.name());
//        searchSourceBuilder.query(QueryBuilders.query);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return searchResponse;
    }
}
