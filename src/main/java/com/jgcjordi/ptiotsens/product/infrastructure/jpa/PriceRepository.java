package com.jgcjordi.ptiotsens.product.infrastructure.jpa;

import com.jgcjordi.ptiotsens.product.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
}
