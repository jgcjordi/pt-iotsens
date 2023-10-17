package com.jgcjordi.ptiotsens.product.infrastructure.mapper;

import com.jgcjordi.ptiotsens.product.domain.Price;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.PriceEntity;
import com.jgcjordi.ptiotsens.product.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public static Price convertToDomain(PriceEntity priceEntity) {
        return new Price(
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPriceList(),
                priceEntity.getProduct().getId(),
                priceEntity.getPriority(),
                priceEntity.getPrice(),
                priceEntity.getCurr()
        );
    }

//    public PriceEntity convertToEntity(Price price) {
//
//        return new PriceEntity(
//                price.getStartDate(),
//                price.getEndDate(),
//                price.getPriceList(),
//                price.getPriority(),
//                price.getPrice(),
//                price.getCurr(),
//                new ProductEntity(price.getProductId())
//        );
//    }
}
