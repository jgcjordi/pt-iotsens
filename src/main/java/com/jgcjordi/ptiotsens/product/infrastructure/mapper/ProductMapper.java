package com.jgcjordi.ptiotsens.product.infrastructure.mapper;

import com.jgcjordi.ptiotsens.product.domain.Product;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final BrandMapper brandMapper;

    public ProductMapper(
            BrandMapper brandMapper,
            PriceMapper priceMapper
    ) {
        this.brandMapper = brandMapper;
    }

    public Product convertToDomain(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                brandMapper.convertToDomain(productEntity.getBrand()),
                productEntity.getPrices().stream().map(PriceMapper::convertToDomain).collect(Collectors.toList())
        );
    }
}
