package com.jgcjordi.ptiotsens.product.infrastructure.controller.response;

import java.time.LocalDateTime;

public class PriceProductResponse {
    private Long productId;
    private Long brandId;
    private int rateToApplyId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double finalPrice;

    public PriceProductResponse() {
    }

    public PriceProductResponse(
            Long productId,
            Long brandId,
            int rateToApplyId,
            LocalDateTime startDate,
            LocalDateTime endDate,
            Double price
    )
    {
        this.productId = productId;
        this.brandId = brandId;
        this.rateToApplyId = rateToApplyId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public int getRateToApplyId() {
        return rateToApplyId;
    }

    public void setRateToApplyId(int rateToApplyId) {
        this.rateToApplyId = rateToApplyId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
