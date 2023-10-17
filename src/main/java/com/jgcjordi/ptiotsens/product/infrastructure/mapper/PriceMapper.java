package com.jgcjordi.ptiotsens.product.infrastructure.mapper;

import com.jgcjordi.ptiotsens.product.domain.Price;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public static Price convertToDomain(PriceEntity priceEntity) {
        return new Price(
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPriceList(),
                priceEntity.getProductId(),
                priceEntity.getPriority(),
                priceEntity.getPrice(),
                priceEntity.getCurr()
        );
    }
}
