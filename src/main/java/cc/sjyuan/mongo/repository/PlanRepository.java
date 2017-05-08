package cc.sjyuan.mongo.repository;

import java.util.List;
import java.util.Map;

public interface PlanRepository {
    List<Map<String, String>> reportStatusStatistics() throws Exception;
}
