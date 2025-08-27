package com.fullness.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.repository.ProductCategoryResisterRepository;

@Service
public class ProductCategoryResisterServiceImpl implements ProductCategoryResisterService {

    @Autowired
    ProductCategoryResisterRepository productCategoryResisterRepository;

    @Transactional
    @Override
    public void addProductCategory(ProductCategory productCategory) {
        productCategoryResisterRepository.insert(productCategory);
    }

    @Override
    public List<ProductCategory> getProductCategories() {
        return productCategoryResisterRepository.selectAll();
    }

    @Override
    public ProductCategory getProductCategoryId(Integer id) {
        return productCategoryResisterRepository.selectById(id);
    }

    @Override
    public boolean isCategoryExists(String name) {
        return productCategoryResisterRepository.selectByName(name) != null;
    }
}