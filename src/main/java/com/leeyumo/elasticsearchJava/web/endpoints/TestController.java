package com.leeyumo.elasticsearchJava.web.endpoints;

import com.leeyumo.elasticsearchJava.domain.Vehicle;
import com.leeyumo.elasticsearchJava.domain.indexName.IndexName;
import com.leeyumo.elasticsearchJava.service.HighLevelRestClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private HighLevelRestClientTemplate highLevelRestClientTemplate;

    @PostMapping("createVehicle")
    public int createVehicle(@RequestBody Vehicle vehicle) throws IOException {
        highLevelRestClientTemplate.createByIndexAndId(IndexName.VEHICLE, UUID.randomUUID().toString().replaceAll("-",""),vehicle);
        return 1;
    }

}
