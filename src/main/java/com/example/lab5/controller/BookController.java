package com.example.lab5.controller;

import com.example.lab5.entity.Book;
import com.example.lab5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/search")
    public List<Book> findByGenre(@RequestParam String genre) {
        return bookService.findByGenre(genre);
    }

    @PostMapping
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Book book) {
        bookService.update(id, book);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        bookService.delete(id);
    }
}
