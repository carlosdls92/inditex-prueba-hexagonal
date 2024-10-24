package es.com.inditex.dls.infrastructure.adapter.web;

import es.com.inditex.dls.application.PriceService;
import es.com.inditex.dls.domain.model.Price;
import es.com.inditex.dls.infrastructure.port.web.PriceControllerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceController implements PriceControllerApi {

    private final PriceService priceService;

    @Override
    public Price findPrice(LocalDateTime applyDate, Long productId, Long brandId) {
        return priceService.findPrice(applyDate, productId, brandId);
    }
}
