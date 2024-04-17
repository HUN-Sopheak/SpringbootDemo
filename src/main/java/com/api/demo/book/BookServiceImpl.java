package com.api.demo.book;


import java.util.List;
import java.util.Optional;
public interface BookServiceImpl {
    List<Book> getBooks();
    Optional<Book> findBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Long id);
    
}