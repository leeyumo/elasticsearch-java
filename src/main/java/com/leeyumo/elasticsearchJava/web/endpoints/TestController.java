package com.leeyumo.elasticsearchJava.web.endpoints;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @GetMapping("getDocById")
    public Object getDocById(@RequestParam String docId) throws IOException {
        GetRequest getRequest = new GetRequest("book","12");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        return documentFields;
    }
}
