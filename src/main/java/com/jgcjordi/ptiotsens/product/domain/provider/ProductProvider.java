package com.jgcjordi.ptiotsens.product.domain.provider;

import com.jgcjordi.ptiotsens.product.domain.Product;

public interface ProductProvider {
    Product save(Product product);
    Product findProductByIdAndPriceFromSaleDate(Long id);
}
