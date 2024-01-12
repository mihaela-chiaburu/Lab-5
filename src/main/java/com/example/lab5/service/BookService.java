package com.example.lab5.service;

import com.example.lab5.entity.Book;
import com.example.lab5.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public void create(Book book) {
        bookRepository.create(book);
    }

    public void update(int bookId, Book book) {
        bookRepository.update(bookId, book);
    }

    public void delete(int bookId) {
        bookRepository.delete(bookId);
    }
}
