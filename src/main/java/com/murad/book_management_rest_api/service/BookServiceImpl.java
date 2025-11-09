package com.murad.book_management_rest_api.service;

import com.murad.book_management_rest_api.entity.Book;
import com.murad.book_management_rest_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    public BookServiceImpl(BookRepository theBookRepository) { bookRepository = theBookRepository;}
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);
        Book thebook = null;

        if(result.isPresent()) {
            thebook = result.get();
        }
        else {
            throw new RuntimeException("Did not find book id - " + theId);
        }
        return thebook;
    }

    @Override
    public Book save(Book theBook) {
        return bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }

}
