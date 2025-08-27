package com.fullness.ec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fullness.ec.entity.ProductCategory;

@Service
public interface ProductCategoryService {

    List<ProductCategory> getAllCategories();
    // Other methods related to product categories can be defined here
}
