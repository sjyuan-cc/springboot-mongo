package cc.sjyuan.mongo.repository;

import cc.sjyuan.mongo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String>, BookRepositoryCustom {
    @Query("{owner.name: ?0, versions: {$elemMatch: {$in: ?1}}}")
    Page<Book> findAll(String ownerName, List<String> version, Pageable pageable)throws Exception;
}
