package com.example.lab5.controller;

import com.example.lab5.entity.PublishingHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.lab5.service.PublishingHouseService;

import java.util.List;

@RestController
@RequestMapping("publisher")
public class PublishingHouseController {

    @Autowired
    private PublishingHouseService publishingHouseService;

    @GetMapping
    public List<PublishingHouse> findAll(){
        return publishingHouseService.findAll();
    }

    @GetMapping("/search")
    public List<PublishingHouse> findByCountry(@RequestParam String country) {
        return publishingHouseService.findByCountry(country);
    }

    @PostMapping
    public void create(@RequestBody PublishingHouse publishingHouse) {
        publishingHouseService.create(publishingHouse);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody PublishingHouse publishingHouse) {
        publishingHouseService.update(id, publishingHouse);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        publishingHouseService.delete(id);
    }


}
