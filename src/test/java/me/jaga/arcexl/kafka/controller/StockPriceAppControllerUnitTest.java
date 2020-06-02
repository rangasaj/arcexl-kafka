package me.jaga.arcexl.kafka.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import me.jaga.arcexl.kafka.domain.StockPrice;
import me.jaga.arcexl.kafka.service.StockPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StockPriceAppControllerUnitTest {

    @MockBean
    private StockPriceService stockPriceService;

    @Autowired
    private MockMvc mockMvc;

    private final String url = "http://localhost:61999/stockPrice/all";

    private static final StockPrice stockPrice = new StockPrice("sym1", LocalDate.of(2020, 1, 3), 20.0);

    @BeforeEach
    private void setUp() {
        Mockito.when(stockPriceService.selectAllStockPrice()).thenReturn(List.of(stockPrice));
    }

    @Test
    public void testController() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonStockPrice = mapper.writeValueAsString(List.of(stockPrice));

        mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(status().isOk()).andExpect(content().string(equalTo(jsonStockPrice)));
    }
}
