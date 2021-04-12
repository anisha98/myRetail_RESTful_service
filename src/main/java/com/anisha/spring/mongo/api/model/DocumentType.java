package com.anisha.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DocumentType")
public class DocumentType {

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }

    private ProductPrice productPrice;
    private DescriptionModel descriptionModel;
    @Id
    private int id;
    @PersistenceConstructor
    public DocumentType(int id,ProductPrice productPrice,DescriptionModel descriptionModel){
        super();
        this.id = id;
        this.productPrice = productPrice;
        this.descriptionModel = descriptionModel;
    }
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DescriptionModel getDescriptionModel() {
        return descriptionModel;
    }

    public void setDescriptionModel(DescriptionModel descriptionModel) {
        this.descriptionModel = descriptionModel;
    }
}
