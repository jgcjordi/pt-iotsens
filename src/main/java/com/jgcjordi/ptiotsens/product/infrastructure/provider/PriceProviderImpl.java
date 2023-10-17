package com.jgcjordi.ptiotsens.product.infrastructure.provider;

import com.jgcjordi.ptiotsens.product.domain.Price;
import com.jgcjordi.ptiotsens.product.domain.provider.PriceProvider;
import com.jgcjordi.ptiotsens.product.infrastructure.jpa.PriceRepository;
import com.jgcjordi.ptiotsens.product.infrastructure.mapper.PriceMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

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
    public Price findProductPriceBetweenDates(Long id, LocalDateTime applicationDate) {
        return PriceMapper.convertToDomain(
                priceRepository.findPriceOfProductBetweenDatesAndBrandId(id, applicationDate));
    }
}
