package com.murad.book_management_rest_api.repository;

import com.murad.book_management_rest_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {


}
