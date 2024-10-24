package es.com.inditex.dls.infrastructure.adapter.db.repository;

import es.com.inditex.dls.infrastructure.adapter.db.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceJPARepository extends JpaRepository<PriceEntity, Long> {
    List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long brandId,
            Long productId,
            LocalDateTime startDate,
            LocalDateTime endDate);
}
