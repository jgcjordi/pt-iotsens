package com.jgcjordi.ptiotsens.product.domain.provider;

import com.jgcjordi.ptiotsens.product.domain.Price;

import java.time.LocalDateTime;

public interface PriceProvider {
    Price findProductPriceBetweenDates(Long id, LocalDateTime applicationDate);
}
