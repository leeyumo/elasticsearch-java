package com.leeyumo.elasticsearchJava.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
    @Value("${elasticsearch.host}")
    private String host;//elasticsearch的地址

    @Value("${elasticsearch.port}")
    private Integer port;//elasticsearch的端口

    @Value("${elasticsearch.cluster.name}")
    private String clusterName;//集群

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(host,port,"http")
                )
        );
    }
}
