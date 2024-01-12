package com.example.lab5.repository;

import com.example.lab5.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Author> findAll() {
        return jdbcTemplate.query("SELECT * FROM author;", (resultSet, rowNum) -> {
            Author author = new Author();
            author.setAuthorId(resultSet.getInt("authorId"));
            author.setFirstName(resultSet.getString("firstName"));
            author.setLastName(resultSet.getString("lastName"));
            author.setNationality(resultSet.getString("nationality"));
            return author;
        });
    }

    public Author findById(int authorId) {
        String sql = "SELECT * FROM author where authorId = ?";
        Author author = jdbcTemplate.queryForObject(sql, new Object[]{authorId}, (rs, rowNum) ->
                new Author(
                        rs.getInt("authorId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("nationality")
                ));
        return author;
    }

    public void create(Author author) {
        String sql = "insert into author(authorId, firstName, lastName, nationality) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, author.getAuthorId(), author.getFirstName(), author.getLastName(), author.getNationality());
    }

    public void update(int authorId, Author author) {
        String sql = "update author set firstName = ?, lastName = ? where authorId = ?";
        jdbcTemplate.update(sql, author.getFirstName(), author.getLastName(), authorId);
    }


    public void delete(int authorId) {
        String sql = "DELETE FROM author where authorId = ?";
        jdbcTemplate.update(sql, authorId);
    }

    public boolean existById(int authorId) {
        String sql = "SELECT count(*) FROM author where authorId = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, authorId);
        return count > 0;
    }

    public boolean existByShortName(String lastName) {
        String sql = "SELECT count(*) FROM author where lastName = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, lastName);
        return count > 0;
    }
}
