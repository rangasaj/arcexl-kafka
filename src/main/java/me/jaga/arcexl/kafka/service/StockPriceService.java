package me.jaga.arcexl.kafka.service;

import me.jaga.arcexl.kafka.dao.StockPriceDAO;
import me.jaga.arcexl.kafka.domain.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

public interface StockPriceService {
    void insertStockPrice(StockPrice stockPrice);
    StockPrice selectStockPrice(String stockSymbol, LocalDate priceDate);
    List<StockPrice> selectAllStockPrice();
    void deleteStockPrice(String stockSymbol, LocalDate priceDate);
}
