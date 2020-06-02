package me.jaga.arcexl.kafka.dao;

import me.jaga.arcexl.kafka.domain.StockPrice;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StockPriceDAO {

    @Insert("INSERT INTO stock_price(stock_symbol, price_date, price) VALUES (#{stockSymbol}, #{priceDate}, #{price})")
    void insertStockPrice(StockPrice stockPrice);

    @Select("SELECT stock_symbol, price_date, price FROM stock_price WHERE stock_symbol=#{stockSymbol} AND price_date = #{priceDate}")
    StockPrice selectStockPrice(String stockSymbol, LocalDate priceDate);

    @Select("SELECT stock_symbol, price_date, price FROM stock_price")
    List<StockPrice> selectAllStockPrice();

    @Delete("DELETE FROM stock_price WHERE stock_symbol=#{stockSymbol} AND price_date = #{priceDate}")
    void deleteStockPrice(String stockSymbol, LocalDate priceDate);
}