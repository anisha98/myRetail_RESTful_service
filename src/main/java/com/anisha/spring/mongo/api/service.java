package com.anisha.spring.mongo.api;

import com.anisha.spring.mongo.api.model.DocumentType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class service {
    private final MongoTemplate mongoTemplate;

    public service(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public List<DocumentType> allTheDescription(long id){
        Query query = new Query()
                .addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.find(query,DocumentType.class);
    }

    public List<DocumentType> queryNameId(long id,String name){
        Query query = new Query()
                .addCriteria(Criteria.where("id").is(id).and("descriptionModel.productName").is(name));
        return mongoTemplate.find(query,DocumentType.class);
    }
}
