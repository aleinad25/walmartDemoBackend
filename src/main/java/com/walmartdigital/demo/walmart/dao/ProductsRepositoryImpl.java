package com.walmartdigital.demo.walmart.dao;

import com.walmartdigital.demo.walmart.model.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductsRepositoryImpl implements ProductsRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Products> getAll() {
        return mongoTemplate.findAll(Products.class);
    }
    @Override
    public List<Products> getProductById(Integer id) {
        Query queryId = new Query(Criteria.where("id").is(id));
        return  mongoTemplate.find(queryId, Products.class);
    }

    @Override
    public List<Products> findProductsByCriteria(String param, Pageable page) {
        final Query query = new Query().with(page);
        final List<Criteria> criteria = new ArrayList<>();
        if (param != null && !param.isEmpty())
            criteria.add(Criteria.where("brand").regex(param));
        if (param != null && !param.isEmpty())
            criteria.add(Criteria.where("description").regex(param));
        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().orOperator(criteria.toArray(new Criteria[criteria.size()])));
        return mongoTemplate.find(query, Products.class);
    }
}
