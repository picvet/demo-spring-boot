package com.example.bookstore.repository;

import com.example.bookstore.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class BookRepositoryImpl implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findById(Long id) {
        return books.get(id);
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(nextId);
            nextId++;
        }
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
            return book;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        books.remove(id);
    }
}
