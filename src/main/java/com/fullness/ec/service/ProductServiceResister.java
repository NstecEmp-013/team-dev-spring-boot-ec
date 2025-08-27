package com.fullness.ec.service;

import java.util.List;

import com.fullness.ec.entity.Product;
import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.form.ProductForm;

public interface ProductServiceResister {

    List<Product> getProducts();

    List<ProductCategory> getProductCategories();

    void registerProduct(ProductForm form);

}
