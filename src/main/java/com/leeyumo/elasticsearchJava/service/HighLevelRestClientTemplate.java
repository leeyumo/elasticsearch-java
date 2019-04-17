package com.leeyumo.elasticsearchJava.service;

import com.leeyumo.elasticsearchJava.domain.indexName.IndexName;

import java.io.IOException;

public interface HighLevelRestClientTemplate {
    boolean createByIndexAndId(IndexName indexName, String id, Object source) throws IOException;
}
