package com.leeyumo.elasticsearchJava.service.impl;

import com.alibaba.fastjson.JSON;
import com.leeyumo.elasticsearchJava.domain.indexName.IndexName;
import com.leeyumo.elasticsearchJava.service.HighLevelRestClientTemplate;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HighLevelRestClientTemplateImpl implements HighLevelRestClientTemplate {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

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
}
