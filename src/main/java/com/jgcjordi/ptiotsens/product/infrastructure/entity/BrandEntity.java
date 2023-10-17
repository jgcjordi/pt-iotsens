package com.jgcjordi.ptiotsens.product.infrastructure.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "brand")
@DynamicUpdate
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public BrandEntity() {

    }

    public BrandEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
