package com.example.lab5.service;

import com.example.lab5.entity.PublishingHouse;
import com.example.lab5.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingHouseService {

    @Autowired
    private PublishingHouseRepository publishingHouseRepository;

    public List<PublishingHouse> findAll() {
        return publishingHouseRepository.findAll();
    }

    public List<PublishingHouse> findByCountry(String country) {
        return publishingHouseRepository.findByCountry(country);
    }

    public void create(PublishingHouse publishingHouse) {
        publishingHouseRepository.create(publishingHouse);
    }

    public void update(int publishingHouseId, PublishingHouse publishingHouse) {
        publishingHouseRepository.update(publishingHouseId, publishingHouse);
    }

    public void delete(int publishingHouseId) {
        publishingHouseRepository.delete(publishingHouseId);
    }
}
