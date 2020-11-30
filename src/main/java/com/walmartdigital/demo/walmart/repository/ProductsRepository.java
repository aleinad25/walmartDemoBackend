package com.walmartdigital.demo.walmart.repository;

import com.walmartdigital.demo.walmart.dao.ProductsRepositoryCustom;
import com.walmartdigital.demo.walmart.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String>, ProductsRepositoryCustom {
}
