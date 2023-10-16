package com.jgcjordi.ptiotsens.product.infrastructure.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable("id") int id) {
        return ResponseEntity.ok("HolaV5");
    }
}
