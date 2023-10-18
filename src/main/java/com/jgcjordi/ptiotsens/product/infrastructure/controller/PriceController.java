package com.jgcjordi.ptiotsens.product.infrastructure.controller;

import com.jgcjordi.ptiotsens.product.application.PriceProducts;
import com.jgcjordi.ptiotsens.product.domain.Price;
import com.jgcjordi.ptiotsens.product.infrastructure.controller.response.PriceProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceController {

    private final PriceProducts priceProducts;

    public PriceController(PriceProducts priceProducts) {
        this.priceProducts = priceProducts;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductPrice(
            @PathVariable("id") Long id,
            @RequestParam("applicationDate") String applicationDate
    ) {
        PriceProductResponse priceProductResponse = priceProducts.getPriceOfProduct(id, LocalDateTime.parse(applicationDate));
        if(priceProductResponse != null){
            return ResponseEntity.ok(priceProductResponse);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Not found any price on this data to this product");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Price>> getAllPrices() {
            return ResponseEntity.ok(priceProducts.getAllPrices());
    }
}

