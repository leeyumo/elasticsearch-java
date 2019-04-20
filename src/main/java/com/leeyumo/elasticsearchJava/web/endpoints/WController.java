package com.leeyumo.elasticsearchJava.web.endpoints;

import com.leeyumo.elasticsearchJava.domain.Vehicle;
import com.leeyumo.elasticsearchJava.domain.indexName.IndexName;
import com.leeyumo.elasticsearchJava.service.HighLevelRestClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("w")
public class WController {
    @Autowired
    private HighLevelRestClientTemplate highLevelRestClientTemplate;

    @PostMapping("createVehicle")
    public int createVehicle(@RequestBody Vehicle vehicle) throws IOException {
        highLevelRestClientTemplate.createByIndexAndId(IndexName.VEHICLE, UUID.randomUUID().toString().replaceAll("-",""),vehicle);
        return 1;
    }

    @GetMapping("checkConnected")
    public String checkConnected(){
        return "本地Spring Boot应用连接成功！";
    }
}
