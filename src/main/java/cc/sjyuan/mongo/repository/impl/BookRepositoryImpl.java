package cc.sjyuan.mongo.repository.impl;

import cc.sjyuan.mongo.repository.BookRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepositoryImpl implements BookRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Map<String, Object>> generateStatusStatistics() throws Exception {
        String mapFunction = "function () { emit(this.type, 1); }";
        String reduceFunction = "function (key, values) { return Array.sum(values); }";

        MapReduceResults<Map> mapReduceResult = mongoTemplate.mapReduce("book",
                mapFunction, reduceFunction, Map.class);
        List<Map<String, Object>> result = new ArrayList<>();

        mapReduceResult.forEach(item -> {
            Map<String, Object> statusItem = new HashMap<>();
            statusItem.put("type", item.get("_id").toString());
            statusItem.put("value", Float.valueOf(item.get("value").toString()).intValue());
            result.add(statusItem);
        });
        return result;
    }
}
