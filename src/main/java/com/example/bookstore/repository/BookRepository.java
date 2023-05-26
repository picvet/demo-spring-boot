package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
    Book update(Book book);
    void delete(Long id);
}
