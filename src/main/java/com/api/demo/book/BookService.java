package com.api.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.micrometer.core.ipc.http.HttpSender.Response;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceImpl{

    private final BookRepo bookRepo;
    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public ResponseEntity<String> deleteBook(Book book) {
        Optional<Book> existingBookId = bookRepo.findById(book.getId());
        if(existingBookId.isPresent()){
            Book existinBook = existingBookId.get();
            bookRepo.deleteById(existinBook.getId());
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.badRequest().body("Book not found");
    }

    @Override
    public Book updateBook(Book book){
        Optional<Book> existingBookId = bookRepo.findById(book.getId());
        if(existingBookId.isPresent()){
            Book existingBook = existingBookId.get();
            existingBook.setAuthor(book.getAuthor());
            existingBook.setDescription(book.getDescription());
            existingBook.setTitle(book.getTitle());
            return bookRepo.save(existingBook);
        }else{
            throw new IllegalArgumentException("Book with id " + book.getId() + " not found");
        }
    }
}
