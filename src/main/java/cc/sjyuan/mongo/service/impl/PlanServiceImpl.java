package cc.sjyuan.mongo.service.impl;

import cc.sjyuan.mongo.entity.Plan;
import cc.sjyuan.mongo.repository.PlanMongoRepository;
import cc.sjyuan.mongo.repository.PlanRepository;
import cc.sjyuan.mongo.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanMongoRepository planMongoRepository;

    @Override
    public Plan create(Plan plan) throws Exception {
        return planMongoRepository.save(plan);
    }

    @Override
    public List<Map<String, String>> reportStatusStatistics() throws Exception {
        return planRepository.reportStatusStatistics();
    }
}
