package com.leeyumo.elasticsearchJava.service;

import com.leeyumo.elasticsearchJava.domain.indexName.IndexName;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

public interface HighLevelRestClientTemplate {
    boolean createByIndexAndId(IndexName indexName, String id, Object source) throws IOException;

    Object getSource(IndexName indexName, SearchSourceBuilder searchSourceBuilder) throws IOException;
}
