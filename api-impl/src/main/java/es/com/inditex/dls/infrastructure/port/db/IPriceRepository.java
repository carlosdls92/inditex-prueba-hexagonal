package es.com.inditex.dls.infrastructure.port.db;

import es.com.inditex.dls.domain.model.Price;

import java.time.LocalDateTime;

public interface IPriceRepository {
    Price findPrice(LocalDateTime applyDate, Long productId, Long brandId);
}
