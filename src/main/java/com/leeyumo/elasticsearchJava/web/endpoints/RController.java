package com.leeyumo.elasticsearchJava.web.endpoints;

import com.leeyumo.elasticsearchJava.domain.constant.VehicleBrand;
import com.leeyumo.elasticsearchJava.domain.indexName.IndexName;
import com.leeyumo.elasticsearchJava.service.HighLevelRestClientTemplate;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RequestMapping("r")
@RestController
public class RController {
    @Autowired
    private HighLevelRestClientTemplate highLevelRestClientTemplate;

    @GetMapping("queryTest")
    public Object queryTest() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //查找大众下，18万以下的车
        final MatchQueryBuilder brand = QueryBuilders.matchQuery("brand", VehicleBrand.DasAuto.name());
        final RangeQueryBuilder price = QueryBuilders.rangeQuery("price").lte(180000);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(brand).must(price);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchSourceBuilder.query(boolQueryBuilder);
        return highLevelRestClientTemplate.getSource(IndexName.VEHICLE,searchSourceBuilder);
    }
}
