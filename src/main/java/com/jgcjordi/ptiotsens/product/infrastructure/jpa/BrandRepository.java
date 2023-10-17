package com.jgcjordi.ptiotsens.product.infrastructure.jpa;

import com.jgcjordi.ptiotsens.product.infrastructure.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
