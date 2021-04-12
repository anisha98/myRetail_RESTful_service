package com.anisha.spring.mongo.api.repository;

import com.anisha.spring.mongo.api.model.DocumentType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<DocumentType, Integer>{

}
