package com.fullness.ec.helper;

import org.springframework.stereotype.Component;

import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.form.ProductCategoryForm;

@Component
public class ProductCategoryHelper {

    public ProductCategory convert(ProductCategoryForm productCategoryForm) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(productCategoryForm.getName());
        return productCategory;
    }
}
