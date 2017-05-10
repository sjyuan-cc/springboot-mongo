package cc.sjyuan.mongo.service.impl;

import cc.sjyuan.mongo.repository.BookRepository;
import cc.sjyuan.mongo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Map<String, Object>> reportStatusStatistics() throws Exception {
        return bookRepository.generateStatusStatistics();
    }
}
