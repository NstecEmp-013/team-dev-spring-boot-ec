package com.fullness.ec.entity;

import lombok.Data;

@Data
public class Product {

    private Integer id;
    private String name;
    private Integer price;
    private String imageUrl;
    private Integer productCategoryId;
    private Integer deleteFlag;

    private ProductStock productStock;
    private ProductCategory productCategory;


}