package com.jgcjordi.ptiotsens.product.infrastructure.controller;

import com.jgcjordi.ptiotsens.product.application.GetProduct;
import com.jgcjordi.ptiotsens.product.domain.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final GetProduct getProduct;

    public ProductController(GetProduct getProduct) {
        this.getProduct = getProduct;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(getProduct.invoke(id));
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<String> get(@PathVariable("id") int id) {
        return ResponseEntity.ok("Hola");
    }
}
