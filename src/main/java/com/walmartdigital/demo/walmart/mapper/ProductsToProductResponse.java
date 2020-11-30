package com.walmartdigital.demo.walmart.mapper;

import com.walmartdigital.demo.walmart.common.ProductUtils;
import com.walmartdigital.demo.walmart.model.ProductResponse;
import com.walmartdigital.demo.walmart.model.Products;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductsToProductResponse {

    public List<ProductResponse> mapper(List<Products> products){
        return products.stream()
                .filter(Objects::nonNull)
                .map(product -> {
            ProductResponse productResponse = ProductResponse.builder()
                    .brand(product.getBrand())
                    .description(product.getDescription())
                    .image(product.getImage())
                    .id(Integer.toString(product.getId()))
                    .price(product.getPrice()).build();
            return getOffer(productResponse);

        }).collect(Collectors.toList());

    }

    public ProductResponse getOffer(ProductResponse productResponse) {
        if (ProductUtils.isPalindrome(productResponse.getBrand())
                || ProductUtils.isPalindrome(productResponse.getDescription())
                || ProductUtils.isPalindromeNumber(Integer.parseInt(productResponse.getId()))) {
            BigDecimal salePrice = ProductUtils.getSalePrice(productResponse.getPrice());
            productResponse.setPrice(salePrice);
            productResponse.setDiscount("Sale 50%");
        }else{
            productResponse.setDiscount("");
        }
        return productResponse;
    }

}
