package com.jgcjordi.ptiotsens.product.infrastructure.jpa;

import com.jgcjordi.ptiotsens.product.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query(
            value =
                    """
                        SELECT *
                        FROM price p
                        WHERE p.product_id = :id AND p.start_date <= :date AND p.end_date >= :date
                        ORDER BY p.priority ASC
                    """,
            nativeQuery = true
    )
    List<PriceEntity> findPricesOfProductBetweenDatesAndBrandId(
            @Param("id") Long id,
            @Param("date") LocalDateTime date);
}
