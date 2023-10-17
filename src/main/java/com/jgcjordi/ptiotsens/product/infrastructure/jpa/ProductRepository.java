package com.jgcjordi.ptiotsens.product.infrastructure.jpa;

import com.jgcjordi.ptiotsens.product.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(
            value =
                    """
                        SELECT p.*
                        FROM product p
                        LEFT JOIN price pr ON (pr.product_id = p.id)
                        WHERE p.id = :id AND pr.start_date <= :date AND pr.end_date >= :date
                    """,
            nativeQuery = true
    )
    ProductEntity findProductWithPriceBetweenDatesAndId(
            @Param("id") Long id,
            @Param("date") LocalDateTime date);
}
