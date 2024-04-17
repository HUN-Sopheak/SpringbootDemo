package com.api.demo.book;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.api.demo.book.BookService;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/book")
public class BookController {
 private static BookService bookService;

 @Autowired
 public BookController(BookService bookService) {
    this.bookService = bookService;
 }

 @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks(); 
    }

 @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
 
    
}
