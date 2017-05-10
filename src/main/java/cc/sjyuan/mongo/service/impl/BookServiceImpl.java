package cc.sjyuan.mongo.service.impl;

import cc.sjyuan.mongo.entity.Book;
import cc.sjyuan.mongo.repository.BookRepository;
import cc.sjyuan.mongo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository planRepository;

    @Override
    public Book create(Book plan) throws Exception {
        return planRepository.save(plan);
    }


    @Override
    public Page<Book> getPageableList(String ownerName, String version, int currentPage, int pageSize) throws Exception {
        Pageable pageable = new PageRequest(currentPage, pageSize, new Sort(Sort.Direction.DESC, "publishDate"));
        return planRepository.findAll(ownerName, Collections.singletonList(version), pageable);
    }
}
