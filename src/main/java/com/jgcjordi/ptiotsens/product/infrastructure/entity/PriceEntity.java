package com.jgcjordi.ptiotsens.product.infrastructure.entity;

import com.jgcjordi.ptiotsens.product.domain.Currency;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.time.LocalDateTime;

@Entity(name = "price")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private int priceList;

    @Column(name = "priority")
    private int priority;

    @Column(name = "price")
    private double price;

    @Column(name = "curr")
    @Enumerated(EnumType.STRING)
    private Currency curr;

    @Column(name = "product_id")
    private Long productId;

    public PriceEntity() {

    }

    public PriceEntity(
            Long id,
            LocalDateTime startDate,
            LocalDateTime endDate,
            int priceList,
            int priority,
            double price,
            Currency curr,
            Long productId
    ) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
