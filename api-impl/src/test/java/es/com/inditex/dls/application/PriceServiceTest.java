package es.com.inditex.dls.application;

import es.com.inditex.dls.domain.model.Price;
import es.com.inditex.dls.infrastructure.port.db.IPriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {
    @Mock
    private IPriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @Test
    public void testFindPrice() {
        LocalDateTime applyDate = LocalDateTime.of(2023, 11, 10, 10, 0);
        Long productId = 1L;
        Long brandId = 1L;

        Price expectedPrice = new Price();
        when(priceRepository.findPrice(applyDate, productId, brandId)).thenReturn(expectedPrice);

        Price actualPrice = priceService.findPrice(applyDate, productId, brandId);

        assertEquals(expectedPrice, actualPrice);
        verify(priceRepository).findPrice(applyDate, productId, brandId);
    }
}