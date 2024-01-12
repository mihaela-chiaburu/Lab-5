package com.example.lab5.repository;

import com.example.lab5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book;", (resultSet, rowNum) -> {
            Book book = new Book();
            book.setBookId(resultSet.getInt("bookId"));
            book.setTitle(resultSet.getString("title"));
            book.setIsbn(resultSet.getString("isbn"));
            book.setPublicationYear(resultSet.getInt("publicationYear"));
            book.setGenre(resultSet.getString("genre"));
            book.setCopiesAvailable(resultSet.getInt("copiesAvailable"));
            return book;
        });
    }

    public List<Book> findByGenre(String genre) {
        String sql = "SELECT * FROM book WHERE genre = ?";
        return jdbcTemplate.query(sql, new Object[]{genre}, (resultSet, rowNum) -> {
            Book book = new Book();
            book.setBookId(resultSet.getInt("bookId"));
            book.setTitle(resultSet.getString("title"));
            book.setIsbn(resultSet.getString("isbn"));
            book.setPublicationYear(resultSet.getInt("publicationYear"));
            book.setGenre(resultSet.getString("genre"));
            book.setCopiesAvailable(resultSet.getInt("copiesAvailable"));
            return book;
        });
    }

    public void create(Book book) {
        String sql = "insert into book(bookId, title, isbn, publicationYear, genre, copiesAvailable) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookId(), book.getTitle(), book.getIsbn(), book.getPublicationYear(), book.getGenre(), book.getCopiesAvailable());
    }


    public void update(int bookId, Book book) {
        String sql = "update book set isbn = ?, copiesAvailable = ? where bookId = ?";
        jdbcTemplate.update(sql, book.getIsbn(), book.getCopiesAvailable(), bookId);
    }

    public void delete(int bookId) {
        String sql = "DELETE FROM book where bookId = ?";
        jdbcTemplate.update(sql, bookId);
    }
}
