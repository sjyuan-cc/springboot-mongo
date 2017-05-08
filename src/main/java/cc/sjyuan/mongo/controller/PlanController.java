package cc.sjyuan.mongo.controller;

import cc.sjyuan.mongo.entity.Plan;
import cc.sjyuan.mongo.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("plans")
public class PlanController {
    @Autowired
    private PlanService planService;


    @PostMapping
    public ResponseEntity<Plan> create(@RequestBody Plan plan) throws Exception {
        return ResponseEntity.ok(planService.create(plan));
    }

    @GetMapping("report/status")
    public ResponseEntity reportStatus() throws Exception {
        return ResponseEntity.ok(planService.reportStatusStatistics());
    }
}
