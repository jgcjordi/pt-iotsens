package com.jgcjordi.ptiotsens.product.infrastructure.mapper;

import com.jgcjordi.ptiotsens.product.domain.Product;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.ProductEntity;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final BrandMapper brandMapper;
    private final PriceMapper priceMapper;

    public ProductMapper(
            BrandMapper brandMapper,
            PriceMapper priceMapper
    ) {
        this.brandMapper = brandMapper;
        this.priceMapper = priceMapper;
    }

    public Product convertToDomain(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                brandMapper.convertToDomain(productEntity.getBrand()),
                productEntity.getPrices().stream().map(PriceMapper::convertToDomain).collect(Collectors.toList())
        );
    }

    //public ProductEntity convertToEntity(Product product) {
    //    return new ProductEntity(
    //            product.getId(),
    //            product.getName(),
    //            product.getBrand(),
    //            product.getPrices()
    //    );
    //}
}
