package me.jaga.arcexl.kafka.controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockPriceAppControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    private  void setUp() {
         this.url = "http://localhost:" + port +"/stockPrice/all";
    }

    @Test
    public void testController() {
        String expMsg = "[{\"stockSymbol\":\"T-IBM\",\"priceDate\":\"2020-01-03\",\"price\":25.0}]";

        ResponseEntity<String> response = testRestTemplate.getForEntity(url,String.class);
        Assertions.assertEquals(expMsg, response.getBody(), "Message matches");
    }

}
