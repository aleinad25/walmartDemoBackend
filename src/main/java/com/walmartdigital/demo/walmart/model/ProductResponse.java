package com.walmartdigital.demo.walmart.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponse {
    private String id;
    private String brand;
    private String description;
    private String image;
    private String discount;
    private BigDecimal price;
}
