package com.walmartdigital.demo.walmart.api;

import com.walmartdigital.demo.walmart.model.ProductResponse;
import com.walmartdigital.demo.walmart.model.Products;
import com.walmartdigital.demo.walmart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping("/v1/product")
@Validated
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/search")
    public List<ProductResponse> findProducts(@RequestParam (required = true) @NotBlank  String param, @RequestParam(required = false) Integer page){
        return productService.findProducts(Optional.ofNullable(param).orElse(""),Optional.ofNullable(page).orElse(0));
    }


    @GetMapping("/all")
    public List<Products> getProducts(){

        return productService.getProduct();
    }

/*
    @DeleteMapping(value = "{id}")
    public void removeStudent(@PathVariable String id){
        studentService.removeStudent(id);
    }*/
}