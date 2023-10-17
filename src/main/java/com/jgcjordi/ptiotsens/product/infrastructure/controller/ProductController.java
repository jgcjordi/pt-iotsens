package com.jgcjordi.ptiotsens.product.infrastructure.controller;

import com.jgcjordi.ptiotsens.product.application.GetProduct;
import com.jgcjordi.ptiotsens.product.domain.Product;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.BrandEntity;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.PriceEntity;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.BrandRepository;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.PriceRepository;
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
    private final BrandRepository brandRepository;
    private final PriceRepository priceRepository;

    public ProductController(GetProduct getProduct, BrandRepository brandRepository, PriceRepository priceRepository) {
        this.getProduct = getProduct;
        this.brandRepository = brandRepository;
        this.priceRepository = priceRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(getProduct.invoke(id));
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<String> get(@PathVariable("id") int id) {
        return ResponseEntity.ok("Hola");
    }

    @GetMapping("/x/{id}")
    public ResponseEntity<PriceEntity> xtest(@PathVariable("id") Long id) {
        return ResponseEntity.ok(priceRepository.findById(id).get());
    }
}
