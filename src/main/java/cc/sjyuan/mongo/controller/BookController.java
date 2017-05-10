package cc.sjyuan.mongo.controller;

import cc.sjyuan.mongo.entity.Book;
import cc.sjyuan.mongo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) throws Exception {
        return ResponseEntity.ok(bookService.create(book));
    }
}
