package com.jgcjordi.ptiotsens.product.infrastructure.mapper;

import com.jgcjordi.ptiotsens.product.domain.Brand;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.BrandEntity;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {

    public Brand convertToDomain(BrandEntity brandEntity) {
        return new Brand(
                brandEntity.getId(),
                brandEntity.getName()
        );
    }
}
