package com.walmartdigital.demo.walmart.service;

import com.walmartdigital.demo.walmart.common.ProductUtils;
import com.walmartdigital.demo.walmart.mapper.ProductsToProductResponse;
import com.walmartdigital.demo.walmart.model.ProductResponse;
import com.walmartdigital.demo.walmart.model.Products;
import com.walmartdigital.demo.walmart.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductsRepository productsRepository;
    private final ProductsToProductResponse productsToProductResponse;

    public List<ProductResponse> findProducts(String param, Integer page) {
        if(ProductUtils.isNumber(param)){
            return productsToProductResponse.mapper(productsRepository.getProductById(Integer.parseInt(param)));
        }else {
            return productsToProductResponse.mapper(productsRepository.findProductsByCriteria(param, PageRequest.of(page, 20)));
        }
    }

    public List<Products> getProduct(){
        return productsRepository.getAll();
    }

}
