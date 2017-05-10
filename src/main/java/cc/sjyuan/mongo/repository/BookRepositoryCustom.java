package cc.sjyuan.mongo.repository;

import java.util.List;
import java.util.Map;

public interface BookRepositoryCustom {
    List<Map<String, Object>> generateStatusStatistics() throws Exception;
}
