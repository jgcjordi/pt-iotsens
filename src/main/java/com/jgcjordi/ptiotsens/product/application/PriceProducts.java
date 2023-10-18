package com.jgcjordi.ptiotsens.product.application;

import com.jgcjordi.ptiotsens.product.domain.Price;
import com.jgcjordi.ptiotsens.product.domain.Product;
import com.jgcjordi.ptiotsens.product.domain.provider.ProductProvider;
import com.jgcjordi.ptiotsens.product.domain.provider.PriceProvider;
import com.jgcjordi.ptiotsens.product.infrastructure.controller.response.PriceProductResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceProducts {
    private final PriceProvider priceProvider;
    private final ProductProvider productProvider;

    public PriceProducts(PriceProvider priceProvider, ProductProvider productProvider) {
        this.priceProvider = priceProvider;
        this.productProvider = productProvider;

    }

    public PriceProductResponse getPriceOfProduct(Long id, LocalDateTime applicationDate) {
        List<Price> prices = priceProvider.findProductPricesBetweenDates(id, applicationDate);
        if(!prices.isEmpty()){
            Price price = prices.stream().max(Comparator.comparingInt(Price::getPriority)).get();
            Product product = productProvider.getProduct(price.getProductId());
            return toPriceProductResponse(price, product);
        }
        return null;
    }

    public List<Price> getAllPrices() {
        return priceProvider.getAllPrices();
    }

    private PriceProductResponse toPriceProductResponse(Price price, Product product) {
        return new PriceProductResponse(
                price.getProductId(),
                product.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }
}
