package com.jgcjordi.ptiotsens.product.infrastructure.controller;

import com.jgcjordi.ptiotsens.product.application.GetPrice;
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

@RestController
@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final GetPrice getPrice;

    public ProductController(GetPrice getPrice) {
        this.getPrice = getPrice;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(
            @PathVariable("id") Long id,
            @RequestParam("applicationDate") String applicationDate
    ) {
        PriceProductResponse priceProductResponse = getPrice.invoke(id, LocalDateTime.parse(applicationDate));
        if(priceProductResponse != null){
            return ResponseEntity.ok(priceProductResponse);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Not found any price on this data to this product");
        }
    }
}

