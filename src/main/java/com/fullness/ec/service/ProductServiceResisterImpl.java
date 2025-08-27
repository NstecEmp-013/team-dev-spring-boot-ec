package com.fullness.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.Product;
import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.entity.ProductStock;
import com.fullness.ec.form.ProductForm;
import com.fullness.ec.helper.ProductHelper;
import com.fullness.ec.repository.ProductCategoryRepository;
import com.fullness.ec.repository.ProductRepository;
import com.fullness.ec.repository.ProductStockRepository;

@Service
public class ProductServiceResisterImpl implements ProductServiceResister {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductStockRepository productStockRepository;

    @Autowired
    private ProductHelper productHelper;

    @Transactional
    @Override
    public void registerProduct(ProductForm form) {
        Product product = productHelper.convertToProduct(form);
        productRepository.insert(product);
        ProductStock stock = productHelper.convertToStock(product, form);
        productStockRepository.insert(stock);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> getProducts() {
        return productRepository.selectAll();
    }

    @Override
    public List<ProductCategory> getProductCategories() {
        return productCategoryRepository.selectAll();
    }

}
