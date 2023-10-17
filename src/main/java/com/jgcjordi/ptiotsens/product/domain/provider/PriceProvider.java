package com.jgcjordi.ptiotsens.product.domain.provider;

import com.jgcjordi.ptiotsens.product.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceProvider {
    List<Price> findProductPricesBetweenDates(Long id, LocalDateTime applicationDate);
}
