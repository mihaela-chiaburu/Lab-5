package com.example.lab5.repository;

import com.example.lab5.entity.PublishingHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublishingHouseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PublishingHouse> findAll() {
        return jdbcTemplate.query("SELECT * FROM publishingHouse;", (resultSet, rowNum) -> {
            PublishingHouse publishingHouse = new PublishingHouse();
            publishingHouse.setPublishingHouseId(resultSet.getInt("publishingHouseId"));
            publishingHouse.setName(resultSet.getString("name"));
            publishingHouse.setLocation(resultSet.getString("location"));
            publishingHouse.setCountry(resultSet.getString("country"));
            return publishingHouse;
        });
    }

    public List<PublishingHouse> findByCountry(String country) {
        String sql = "SELECT * FROM publishingHouse WHERE country = ?";
        return jdbcTemplate.query(sql, new Object[]{country}, (resultSet, rowNum) -> {
            PublishingHouse publishingHouse = new PublishingHouse();
            publishingHouse.setPublishingHouseId(resultSet.getInt("publishingHouseId"));
            publishingHouse.setName(resultSet.getString("name"));
            publishingHouse.setLocation(resultSet.getString("location"));
            publishingHouse.setCountry(resultSet.getString("country"));
            return publishingHouse;
        });
    }

    public void create(PublishingHouse publishingHouse) {
        String sql = "insert into publishingHouse(publishingHouseId, name, location, country) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, publishingHouse.getPublishingHouseId(), publishingHouse.getName(), publishingHouse.getLocation(), publishingHouse.getCountry());
    }

    public void update(int publishingHouseId, PublishingHouse publishingHouse) {
        String sql = "update publishingHouse set name = ?, location = ? where publishingHouseId = ?";
        jdbcTemplate.update(sql, publishingHouse.getName(), publishingHouse.getLocation(), publishingHouseId);
    }

    public void delete(int publishingHouseId) {
        String sql = "DELETE FROM publishingHouse where publishingHouseId = ?";
        jdbcTemplate.update(sql, publishingHouseId);
    }
}
