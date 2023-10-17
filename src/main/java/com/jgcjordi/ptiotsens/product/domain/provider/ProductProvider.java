package com.jgcjordi.ptiotsens.product.domain.provider;

import com.jgcjordi.ptiotsens.product.domain.Product;

public interface ProductProvider {
    Product getProduct(Long id);
}
