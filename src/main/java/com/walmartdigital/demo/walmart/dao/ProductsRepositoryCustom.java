package com.walmartdigital.demo.walmart.dao;

import com.walmartdigital.demo.walmart.model.Products;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductsRepositoryCustom {
    List<Products> getAll();
    List<Products> getProductById(Integer id);
    List<Products> findProductsByCriteria(String param, Pageable page);
}
