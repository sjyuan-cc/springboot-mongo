package cc.sjyuan.mongo.service;

import cc.sjyuan.mongo.entity.Plan;

import java.util.List;
import java.util.Map;


public interface PlanService {
    Plan create(Plan plan) throws Exception;

    List<Map<String, String>> reportStatusStatistics() throws Exception;
}
