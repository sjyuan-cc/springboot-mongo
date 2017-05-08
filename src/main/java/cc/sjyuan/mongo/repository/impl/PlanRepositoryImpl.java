package cc.sjyuan.mongo.repository.impl;

import cc.sjyuan.mongo.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlanRepositoryImpl implements PlanRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Map<String, String>> reportStatusStatistics() throws Exception {
        String mapFunction = "function () { emit(this.status, 1); }";
        String reduceFunction = "function (key, values) { return Array.sum(values); }";
        MapReduceResults<Map> results = mongoTemplate.mapReduce("plan", mapFunction, reduceFunction,
                Map.class);
        List<Map<String, String>> res = new ArrayList<>();

        results.forEach(item -> {
            Map<String, String> it = new HashMap<>();
            it.put("status", item.get("_id").toString());
            it.put("value", item.get("value").toString());
            res.add(it);
        });
        return res;
    }
}
