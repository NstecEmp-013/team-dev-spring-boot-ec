package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private String name;
    private Integer price;
    private String imageUrl;
    private Integer productCategoryId;
    private Integer deleteFlag;

    private ProductStock stocks;
    private ProductCategory productCategory;
}