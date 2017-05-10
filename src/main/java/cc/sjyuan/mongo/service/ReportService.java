package cc.sjyuan.mongo.service;


import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Object>> reportStatusStatistics() throws Exception;
}
