package com.api.demo.book;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
public interface BookServiceImpl {
    List<Book> getBooks();
    Optional<Book> findBookById(Long id);
    Book saveBook(Book book);
    Book updateBook(Book book);
    ResponseEntity<String> deleteBook(Book book);
    
}