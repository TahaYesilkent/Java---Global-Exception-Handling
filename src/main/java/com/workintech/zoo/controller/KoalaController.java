package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Mutlaka RestController olmalı
@RequestMapping("/koalas") // application.properties'de context-path tanımlı olduğu için sadece /koalas yazıyoruz
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }

    @PostMapping
    public Koala save(@RequestBody Koala koala) {
        // Testlerin geçmesi için temel doğrulama
        if (koala.getId() <= 0) {
            throw new ZooException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        koalas.put(koala.getId(), koala);
        return koala;
    }

    @GetMapping
    public List<Koala> findAll() {
        return new ArrayList<>(koalas.values());
    }

    @GetMapping("/{id}")
    public Koala find(@PathVariable int id) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Koala not found", HttpStatus.NOT_FOUND);
        }
        return koalas.get(id);
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala koala) {
        koala.setId(id);
        koalas.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        koalas.remove(id);
    }
}