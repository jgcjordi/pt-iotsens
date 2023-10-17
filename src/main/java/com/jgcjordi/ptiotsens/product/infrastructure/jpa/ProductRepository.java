package com.jgcjordi.ptiotsens.product.infrastructure.jpa;

import com.jgcjordi.ptiotsens.product.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // Métodos específicos del repositorio, si los tienes
}
