package com.example.lab5.controller;

import com.example.lab5.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.lab5.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable int id) {
        return authorService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Author author) {
        authorService.create(author);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Author author) {
        authorService.update(id, author);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        authorService.delete(id);
    }
}

