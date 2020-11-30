package com.walmartdigital.demo.walmart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
public class Products {
    @Id
    private ObjectId objectId;
    private Integer id;
    private String brand;
    private String description;
    private String image;
    private BigDecimal price;

    public Products(@JsonProperty Integer id, @JsonProperty("brand") String brand, @JsonProperty("description") String description, @JsonProperty("image") String image, @JsonProperty BigDecimal price) {
        this.id=id;
        this.brand = brand;
        this.description = description;
        this.image= image;
        this.price= price;
    }
}
