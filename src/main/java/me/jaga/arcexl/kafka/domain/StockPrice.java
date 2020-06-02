package me.jaga.arcexl.kafka.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class StockPrice implements Serializable {

    @Id
    private final String stockSymbol;

    @Id
    @JsonFormat(pattern="yyyy-MM-dd")
    private final LocalDate priceDate;
    private final Double price;

    public StockPrice(String stockSymbol, LocalDate priceDate, Double price) {
        this.stockSymbol = stockSymbol;
        this.priceDate = priceDate;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockPrice that = (StockPrice) o;
        return Objects.equals(stockSymbol, that.stockSymbol) &&
                Objects.equals(priceDate, that.priceDate) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockSymbol, priceDate, price);
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getPriceDate() {
        return priceDate;
    }
}
