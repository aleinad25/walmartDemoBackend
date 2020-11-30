package com.walmartdigital.demo.walmart.api;

import com.walmartdigital.demo.walmart.model.ProductResponse;
import com.walmartdigital.demo.walmart.model.Products;
import com.walmartdigital.demo.walmart.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ProductControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService ProductService;

    ProductResponse productAfter;
    @BeforeEach
    public void setup() {
       productAfter = ProductResponse.builder()
               .price(BigDecimal.valueOf(2000))
               .id("23")
               .image("www.image.com")
               .description("producto lavadora")
               .brand("LG")
               .build();

    }

    @Test
    void findProducts() throws Exception {
        given(ProductService.findProducts(anyString(),any())).willReturn(Arrays.asList(ProductResponse.builder().price(BigDecimal.valueOf(2000)).id("23").image("www.image.com").description("producto lavadora").brand("LG").build()));

         mvc.perform((MockMvcRequestBuilders.
                get("/v1/product/search").param("param", "181"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand").value(productAfter.getBrand()));

    }



    @Test
    void getProducts() throws Exception {
        given(ProductService.getProduct()).willReturn(Arrays.asList(new Products(1,"LG", "dsdsad","www.image.cl",BigDecimal.valueOf(2000))));

        mvc.perform((MockMvcRequestBuilders.
                get("/v1/product/all"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand").value("LG"));

    }
}