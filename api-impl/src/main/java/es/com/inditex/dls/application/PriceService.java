package es.com.inditex.dls.application;

import es.com.inditex.dls.domain.model.Price;
import es.com.inditex.dls.infrastructure.port.db.IPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final IPriceRepository priceRepository;

    public Price findPrice(LocalDateTime applyDate, Long productId, Long brandId) {
        return priceRepository.findPrice(applyDate, productId, brandId);
    }

}
