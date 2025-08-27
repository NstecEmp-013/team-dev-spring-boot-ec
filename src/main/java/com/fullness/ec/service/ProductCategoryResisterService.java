package com.fullness.ec.service;

import java.util.List;

import com.fullness.ec.entity.ProductCategory;

public interface ProductCategoryResisterService {
    void addProductCategory(ProductCategory productCategory);

    List<ProductCategory> getProductCategories();

    ProductCategory getProductCategoryId(Integer id);

    boolean isCategoryExists(String name);

}
