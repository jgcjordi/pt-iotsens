package com.jgcjordi.ptiotsens.product.domain.provider;

import com.jgcjordi.ptiotsens.product.domain.Product;

import java.time.LocalDateTime;

public interface ProductProvider {
    Product findProductByIdWithPriceBetweenDates(Long id, LocalDateTime applicationDate);
}
