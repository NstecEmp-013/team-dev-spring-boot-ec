package com.fullness.ec.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fullness.ec.entity.Product;

@Service
public interface ProductService {

    //List<Product> getAllProducts(Pageable pageable);
    Page<Product> getAllProducts(Pageable pageable);

    List<Product> getProductsByCategory(Integer productCategoryId, Pageable pageable);
    
    // ページネーション
    //Page<Product> selectProductsByPage(Integer productCategoryId, Pageable pageable);
}
