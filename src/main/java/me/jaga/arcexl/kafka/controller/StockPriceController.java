package me.jaga.arcexl.kafka.controller;

import me.jaga.arcexl.kafka.domain.StockPrice;
import me.jaga.arcexl.kafka.service.StockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class StockPriceController {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    private StockPriceService stockPriceService;

    @RequestMapping("/stockPrice/all")
    public List<StockPrice> getAllStockPrices() {
        return stockPriceService.selectAllStockPrice();
    }

    @RequestMapping("/stockPrice/insert")
    public void insertStockPrice(StockPrice stockPrice) {
        stockPriceService.insertStockPrice(stockPrice);
    }

    @RequestMapping("/stockPrice/delete")
    public void deleteStockPrice(String stockSymbol, String priceDateString) {
        LocalDate priceDate = LocalDate.parse(priceDateString, formatter);

        stockPriceService.deleteStockPrice(stockSymbol, priceDate);
    }

    @RequestMapping("/stockPrice/get/{stockSymbol}/{priceDateString}")
    public StockPrice insertStockPrice(@PathVariable String stockSymbol, @PathVariable String priceDateString) {
        LocalDate priceDate = LocalDate.parse(priceDateString, formatter);
        return stockPriceService.selectStockPrice(stockSymbol, priceDate);
    }

}
