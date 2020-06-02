package me.jaga.arcexl.kafka.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestA {

    public static void main(String[] args) {
        String priceDateString = "2020-01-03";
        LocalDate priceDate = LocalDate.parse(priceDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("PriceDate = " + priceDate);

    }

}
