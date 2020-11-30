package com.walmartdigital.demo.walmart.service;

import com.walmartdigital.demo.walmart.mapper.ProductsToProductResponse;
import com.walmartdigital.demo.walmart.model.ProductResponse;
import com.walmartdigital.demo.walmart.model.Products;
import com.walmartdigital.demo.walmart.repository.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductService productService;
    @Mock
    ProductsRepository productsRepository;
    @Mock
    ProductsToProductResponse productsToProductResponse;



    @BeforeEach
    void setUp() {
        productService= new ProductService(productsRepository, productsToProductResponse);
    }

    @Test
    void findProducts() {
        when(productsToProductResponse.mapper(any())).thenReturn(Arrays.asList(ProductResponse.builder().price(BigDecimal.valueOf(2000)).id("23").image("www.image.com").description("producto lavadora").brand("LG").build()));
        List<ProductResponse> products = productService.findProducts("181", 0);
        assertEquals("LG",products.get(0).getBrand());

    }

    @Test
    void getProduct() {
        when(productsRepository.getAll()).thenReturn(Arrays.asList(new Products(1,"LG", "dsdsad","www.image.cl",BigDecimal.valueOf(2000))));
        List<Products> products = productService.getProduct();
        assertEquals("LG",products.get(0).getBrand());
    }
}