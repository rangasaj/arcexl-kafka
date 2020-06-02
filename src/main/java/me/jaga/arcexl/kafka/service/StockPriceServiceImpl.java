package me.jaga.arcexl.kafka.service;

import me.jaga.arcexl.kafka.dao.StockPriceDAO;
import me.jaga.arcexl.kafka.domain.StockPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("stockPriceService")
public class StockPriceServiceImpl implements  StockPriceService{
    @Autowired
    private StockPriceDAO stockPriceDAO;

    @Override
    public void insertStockPrice(StockPrice stockPrice) {
        stockPriceDAO.insertStockPrice(stockPrice);
    }

    @Override
    public StockPrice selectStockPrice(String stockSymbol, LocalDate priceDate) {
        return stockPriceDAO.selectStockPrice(stockSymbol,priceDate);
    }

    @Override
    public List<StockPrice> selectAllStockPrice() {
        return stockPriceDAO.selectAllStockPrice();
    }

    @Override
    public void deleteStockPrice(String stockSymbol, LocalDate priceDate) {
        stockPriceDAO.deleteStockPrice(stockSymbol,priceDate);
    }
}
