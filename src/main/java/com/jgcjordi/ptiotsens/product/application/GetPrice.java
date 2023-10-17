package com.jgcjordi.ptiotsens.product.application;

import com.jgcjordi.ptiotsens.product.domain.Price;
import com.jgcjordi.ptiotsens.product.domain.provider.PriceProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GetPrice {
    private final PriceProvider priceProvider;

    public GetPrice(PriceProvider priceProvider) {
        this.priceProvider = priceProvider;
    }

    public Price invoke(Long id, LocalDateTime applicationDate) {
        return priceProvider.findProductPriceBetweenDates(id, applicationDate);
    }
}
