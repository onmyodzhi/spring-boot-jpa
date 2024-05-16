package com.aleksandr.spring.repositories;

import com.aleksandr.spring.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE b.title LIKE CONCAT(:title, '%')")
    List<Book> findAllByTitleStartingWith(@Param("title") String title);
}
