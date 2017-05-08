package cc.sjyuan.mongo.repository;

import cc.sjyuan.mongo.entity.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanMongoRepository extends MongoRepository<Plan, String> {
}
