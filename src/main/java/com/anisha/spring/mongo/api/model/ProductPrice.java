package com.anisha.spring.mongo.api.model;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Price")
public class ProductPrice {

    private double currentPrice;
    private String currencyCode;

    public ProductPrice(){
        super();
    }


    @PersistenceConstructor
    public ProductPrice(String currencyCode, double currentPrice){
        super();
        this.currencyCode = currencyCode;
        this.currentPrice = currentPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
