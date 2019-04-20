package com.leeyumo.elasticsearchJava.web.endpoints;

import com.leeyumo.elasticsearchJava.domain.indexName.IndexName;
import com.leeyumo.elasticsearchJava.service.HighLevelRestClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("r")
@RestController
public class RController {
    @Autowired
    private HighLevelRestClientTemplate highLevelRestClientTemplate;

    @GetMapping("queryTest")
    public Object queryTest() throws IOException {
        
        return highLevelRestClientTemplate.getSource(IndexName.VEHICLE);
    }
}
