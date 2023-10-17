package com.jgcjordi.ptiotsens.product.infrastructure.provider;

import com.jgcjordi.ptiotsens.product.domain.Price;
import com.jgcjordi.ptiotsens.product.domain.provider.PriceProvider;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.PriceRepository;
import com.jgcjordi.ptiotsens.product.infrastructure.mapper.PriceMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceProviderImpl implements PriceProvider {

    private final PriceRepository priceRepository;

    public PriceProviderImpl(
            PriceRepository priceRepository
    ) {
        this.priceRepository = priceRepository;
    }

    @Transactional
    @Override
    public List<Price> findProductPricesBetweenDates(Long id, LocalDateTime applicationDate) {
        return priceRepository.findPricesOfProductBetweenDatesAndBrandId(id, applicationDate)
                .stream().map(PriceMapper::convertToDomain).collect(Collectors.toList());
    }
}
