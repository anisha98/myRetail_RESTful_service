package com.anisha.spring.mongo.api.model;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DescriptionModel")
public class DescriptionModel {

    private String description;
    private String productName;

    @PersistenceConstructor
    public DescriptionModel(String description, String productName){
        super();
        this.description = description;
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public DescriptionModel(){
        super();
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
