package com.anisha.spring.mongo.api;

import com.anisha.spring.mongo.api.model.DescriptionModel;
import com.anisha.spring.mongo.api.model.DocumentType;
import com.anisha.spring.mongo.api.model.ProductPrice;
import com.anisha.spring.mongo.api.repository.ShopRepository;
import com.anisha.spring.mongo.api.resource.ShopController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCase {

    @Autowired
    service service;

    @Autowired
    ShopController shopController;

    @Autowired
    ShopRepository shopRepository;
    @Test
    public void createRows() {
        shopRepository.deleteAll();
        shopRepository.save(new DocumentType(1,new ProductPrice("INR",100.0),new DescriptionModel("Milk Chocolate","Dairy Milk Silk")));
        shopRepository.save(new DocumentType(2,new ProductPrice("INR",300.0),new DescriptionModel("Spinach Leaves","FreshGreens")));
        shopRepository.save(new DocumentType(3,new ProductPrice("INR",50.0),new DescriptionModel("Brinjal","FreshGreens")));
        shopRepository.save(new DocumentType(4,new ProductPrice("INR",500.0),new DescriptionModel("Cup Cakes","Brownie House")));

        shopRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void findall(){
        shopController.getShops();
    }

    @Test
    public void saveShop(){
        shopController.saveShop(new DocumentType(5,new ProductPrice("INR",500.0),new DescriptionModel("Choco Bar","Jenny's Icecream House")));
    }

    @Test
    public void getShops(){
        shopController.getShops();
    }

    @Test
    public void getShopsID(){
        shopController.getShops(4);
    }

    @Test
    public void findNameId(){
        shopController.findNameId(5,"Jenny's Icecream House");
    }

    @Test
    public void deletedShop(){
        shopController.deleteShops(4);
    }
}
