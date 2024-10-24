package es.com.inditex.dls.infrastructure.adapter.db;

import es.com.inditex.dls.domain.model.Price;
import es.com.inditex.dls.infrastructure.adapter.db.model.PriceEntity;
import es.com.inditex.dls.infrastructure.adapter.db.repository.IPriceJPARepository;
import es.com.inditex.dls.infrastructure.port.db.IPriceRepository;
import es.com.inditex.dls.infrastructure.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class PriceAdapter implements IPriceRepository {

    private final IPriceJPARepository priceJPARepository;
    private final PriceMapper priceMapper;

    @Override
    public Price findPrice(LocalDateTime applyDate, Long productId, Long brandId) {
        return priceJPARepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                    brandId,
                    productId,
                    applyDate,
                    applyDate)
                .stream()
                .sorted(Comparator.comparing(PriceEntity::getPriority, Comparator.reverseOrder()))
                .map(priceMapper::toPrice)
                .peek(r -> r.setApplyDate(applyDate))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
