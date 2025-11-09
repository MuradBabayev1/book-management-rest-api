package com.murad.book_management_rest_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.murad.book_management_rest_api.entity.Book;
import com.murad.book_management_rest_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.apache.tomcat.jni.SSLConf.apply;

@RestController

public class BookRestController {
    private BookService bookService;

    private ObjectMapper objectMapper;

    @Autowired
    public BookRestController(BookService theBookService, ObjectMapper theObjectMapper) {
        bookService = theBookService;
        objectMapper = theObjectMapper;
    }

    @GetMapping("/books")
    public List<Book> findAll() { return bookService.findAll(); }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        Book theBook = bookService.findById(bookId);

        if(theBook == null){
            throw new RuntimeException("Book id not found - " + bookId);
        }
        return theBook;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {
        theBook.setId(0);
        Book dbBook = bookService.save(theBook);
        return dbBook;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook) {

        Book dbBook = bookService.save(theBook);
        return dbBook;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        return "Book deleted successfully!";
    }

}
