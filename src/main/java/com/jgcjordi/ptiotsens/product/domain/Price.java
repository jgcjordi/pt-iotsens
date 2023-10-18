package com.jgcjordi.ptiotsens.product.domain;

import java.time.LocalDateTime;

public class Price {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private Long productId;
    private int priority;
    private double price;
    private Currency curr;

    public Price(
            LocalDateTime startDate,
            LocalDateTime endDate,
            int priceList,
            Long productId,
            int priority,
            double price,
            Currency curr
    ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
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

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurr() {
        return curr;
    }

    public void setCurr(Currency curr) {
        this.curr = curr;
    }
}
