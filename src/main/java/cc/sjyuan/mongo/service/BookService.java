package cc.sjyuan.mongo.service;

import cc.sjyuan.mongo.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;


public interface BookService {
    Book create(Book plan) throws Exception;



    Page<Book> getPageableList(String ownerName, String version, int currentPage, int pageSize) throws Exception;
}
