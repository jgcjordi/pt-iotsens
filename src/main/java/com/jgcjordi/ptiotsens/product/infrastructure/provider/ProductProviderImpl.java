package com.jgcjordi.ptiotsens.product.infrastructure.provider;

import com.jgcjordi.ptiotsens.product.domain.Product;
import com.jgcjordi.ptiotsens.product.domain.provider.ProductProvider;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.ProductRepository;
import com.jgcjordi.ptiotsens.product.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductProviderImpl implements ProductProvider {

    private final ProductRepository productRepository;

    public ProductProviderImpl(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long id) {
        return ProductMapper.convertToDomain(productRepository.getReferenceById(id));
    }
}
