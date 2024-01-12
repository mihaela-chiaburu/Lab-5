package com.example.lab5.service;

import com.example.lab5.entity.Author;
import com.example.lab5.exceptions.AlreadyExistException;
import com.example.lab5.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lab5.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(int authorId) {
        if(!authorRepository.existById(authorId)) {
            throw new NotFoundException("Not found author with id: " + authorId);
        }
        return authorRepository.findById(authorId);
    }

    public void create(Author author) {
        if(authorRepository.existByShortName(author.getLastName())) {
            throw new AlreadyExistException(
                    "Already exist author with shortName: " + author.getLastName());
        }
        authorRepository.create(author);
    }

    public void update(int authorId, Author author) {
        authorRepository.update(authorId,author);
    }

    public void delete(int authorId) {
        authorRepository.delete(authorId);
    }
}
