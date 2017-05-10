package cc.sjyuan.mongo.controller;

import cc.sjyuan.mongo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("type")
    public ResponseEntity reportStatus() throws Exception {
        return ResponseEntity.ok(reportService.reportStatusStatistics());
    }
}
