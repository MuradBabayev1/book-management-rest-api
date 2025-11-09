package com.murad.book_management_rest_api.service;

import com.murad.book_management_rest_api.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(int theId);
    Book save(Book theBook);
    void deleteById(int theId);
}
