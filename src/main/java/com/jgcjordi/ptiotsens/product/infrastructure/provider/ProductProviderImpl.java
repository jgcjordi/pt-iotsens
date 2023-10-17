package com.jgcjordi.ptiotsens.product.infrastructure.provider;

import com.jgcjordi.ptiotsens.product.domain.Product;
import com.jgcjordi.ptiotsens.product.domain.provider.ProductProvider;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.ProductRepository;
import com.jgcjordi.ptiotsens.product.infrastructure.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductProviderImpl implements ProductProvider {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductProviderImpl(
            ProductMapper productMapper,
            ProductRepository productRepository
    ) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public Product findProductByIdWithPriceBetweenDates(Long id, LocalDateTime applicationDate) {
        System.out.println(applicationDate);
        return productMapper.convertToDomain(
                productRepository.findProductWithPriceBetweenDatesAndId(id, applicationDate));
    }
}
