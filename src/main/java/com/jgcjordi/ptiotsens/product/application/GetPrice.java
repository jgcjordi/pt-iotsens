package com.jgcjordi.ptiotsens.product.application;

import com.jgcjordi.ptiotsens.product.domain.Price;
import com.jgcjordi.ptiotsens.product.domain.provider.PriceProvider;
import com.jgcjordi.ptiotsens.product.infrastructure.controller.response.PriceProductResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class GetPrice {
    private final PriceProvider priceProvider;

    public GetPrice(PriceProvider priceProvider) {
        this.priceProvider = priceProvider;
    }

    public PriceProductResponse invoke(Long id, LocalDateTime applicationDate) {
        List<Price> prices = priceProvider.findProductPricesBetweenDates(id, applicationDate);
        if(!prices.isEmpty()){
            return toPriceProductResponse(prices.stream().max(Comparator.comparingInt(Price::getPriority)).get());
        }
        return null;
    }

    private PriceProductResponse toPriceProductResponse(Price price) {
        return new PriceProductResponse(
                price.getProductId(),
                1L,
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }

}
