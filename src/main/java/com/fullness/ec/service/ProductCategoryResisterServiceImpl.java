package com.fullness.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.repository.ProductCategoryRepository;

@Service
public class ProductCategoryResisterServiceImpl implements ProductCategoryResisterService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Transactional
    @Override
    public void addProductCategory(ProductCategory productCategory) {
        productCategoryRepository.insert(productCategory);
    }

    @Override
    public List<ProductCategory> getProductCategories() {
        return productCategoryRepository.selectAll();
    }

    @Override
    public ProductCategory getProductCategoryId(Integer id) {
        return productCategoryRepository.selectById(id);
    }

    @Override
    public boolean isCategoryExists(String name) {
        return productCategoryRepository.selectByName(name) != null;
    }
}