package es.com.inditex.dls.infrastructure.adapter.web;

import es.com.inditex.dls.domain.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String productId = "35455";
    private String brandId = "1";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Test
    void test1() throws Exception {
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        Price expected = Price
                .builder()
                .id(1L)
                .applyDate(applyDate)
                .productId(35455L)
                .brandId(1L)
                .priceToApply("1")
                .priceFinal("35.50 EUR")
                .build();

        findPrice(applyDate, expected);
    }

    @Test
    void test2() throws Exception {
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        Price expected = Price
                .builder()
                .id(2L)
                .applyDate(applyDate)
                .productId(35455L)
                .brandId(1L)
                .priceToApply("2")
                .priceFinal("25.45 EUR")
                .build();

        findPrice(applyDate, expected);
    }

    @Test
    void test3() throws Exception {
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        Price expected = Price
                .builder()
                .id(1L)
                .applyDate(applyDate)
                .productId(35455L)
                .brandId(1L)
                .priceToApply("1")
                .priceFinal("35.50 EUR")
                .build();

        findPrice(applyDate,expected);
    }

    @Test
    void test4() throws Exception {
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        Price expected = Price
                .builder()
                .id(3L)
                .applyDate(applyDate)
                .productId(35455L)
                .brandId(1L)
                .priceToApply("3")
                .priceFinal("30.50 EUR")
                .build();

        findPrice(applyDate, expected);
    }

    @Test
    void test5() throws Exception {
        LocalDateTime applyDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        Price expected = Price
                .builder()
                .id(4L)
                .applyDate(applyDate)
                .productId(35455L)
                .brandId(1L)
                .priceToApply("4")
                .priceFinal("38.95 EUR")
                .build();

        findPrice(applyDate, expected);
    }

    public ResultActions findPrice(LocalDateTime applyDate, Price expected) throws Exception {
        return mockMvc.perform(get("/prices/find")
                        .param("apply-date", applyDate.toString())
                        .param("product-id",productId)
                        .param("brand-id",brandId)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(expected.getId()))
                .andExpect(jsonPath("$.applyDate").value(formatter.format(expected.getApplyDate())))
                .andExpect(jsonPath("$.productId").value(expected.getProductId()))
                .andExpect(jsonPath("$.brandId").value(expected.getBrandId()))
                .andExpect(jsonPath("$.priceToApply").value(expected.getPriceToApply()))
                .andExpect(jsonPath("$.priceFinal").value(expected.getPriceFinal()))
                ;
    }

}