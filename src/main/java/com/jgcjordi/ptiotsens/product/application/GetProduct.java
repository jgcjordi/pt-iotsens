package com.jgcjordi.ptiotsens.product.application;

import com.jgcjordi.ptiotsens.product.domain.Product;
import com.jgcjordi.ptiotsens.product.domain.provider.ProductProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GetProduct {
    private final ProductProvider productProvider;

    public GetProduct(ProductProvider productProvider) {
        this.productProvider = productProvider;
    }

    public Product invoke(Long id, LocalDateTime applicationDate) {
        return productProvider.findProductByIdWithPriceBetweenDates(id, applicationDate);
    }
}
