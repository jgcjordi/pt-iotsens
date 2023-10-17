package com.jgcjordi.ptiotsens.product.domain;

import com.jgcjordi.ptiotsens.product.infrastructure.entity.BrandEntity;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.PriceEntity;

import java.util.List;

public class Product {
    private Long id;
    private String name;
    private Brand brand;
    private List<Price> prices;

    public Product(
            Long id,
            String name,
            Brand brand,
            List<Price> prices
    ) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.prices = prices;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public List<Price> getPrices() {
        return prices;
    }
}