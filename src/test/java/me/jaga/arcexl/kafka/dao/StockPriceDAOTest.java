package me.jaga.arcexl.kafka.dao;

import me.jaga.arcexl.kafka.dao.StockPriceDAO;
import me.jaga.arcexl.kafka.domain.StockPrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

@SpringBootTest
@Transactional
public class StockPriceDAOTest {
    @Autowired
    private StockPriceDAO stockPriceDAO;

    @Test
    public void testInsert() {
        StockPrice  stockPrice = getTestStockPrice();

        stockPriceDAO.insertStockPrice(stockPrice);
        StockPrice gotStockPrice = stockPriceDAO.selectStockPrice(stockPrice.getStockSymbol(),stockPrice.getPriceDate());

        Assertions.assertEquals(stockPrice,gotStockPrice,"StockPrice got=" + gotStockPrice);
    }

    private StockPrice getTestStockPrice() {
        String stockSymbol = "testSym";
        LocalDate priceDate = LocalDate.of(2019, 1, 9);
        StockPrice stockPrice = new StockPrice(stockSymbol, priceDate, 12.0);

        return stockPrice;
    }
    @Test
    public void testDelete() {

        StockPrice  stockPrice = getTestStockPrice();

        stockPriceDAO.insertStockPrice(stockPrice);
        StockPrice gotStockPrice = stockPriceDAO.selectStockPrice(stockPrice.getStockSymbol(),stockPrice.getPriceDate());

        Assertions.assertEquals(stockPrice,gotStockPrice,"StockPrice got=" + gotStockPrice);

        stockPriceDAO.deleteStockPrice(stockPrice.getStockSymbol(), stockPrice.getPriceDate());

        gotStockPrice = stockPriceDAO.selectStockPrice(stockPrice.getStockSymbol(),stockPrice.getPriceDate());

        Assertions.assertEquals(null,gotStockPrice,"StockPrice got=" + gotStockPrice);
    }

    @Test
    public void testSelect() {
        StockPrice  stockPrice = getTestStockPrice();
        StockPrice gotStockPrice = stockPriceDAO.selectStockPrice(stockPrice.getStockSymbol(),stockPrice.getPriceDate());
        stockPriceDAO.deleteStockPrice(stockPrice.getStockSymbol(), stockPrice.getPriceDate());
        System.out.println(gotStockPrice);

    }

}
