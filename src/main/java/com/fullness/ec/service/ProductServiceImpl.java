package com.fullness.ec.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fullness.ec.entity.Product;
import com.fullness.ec.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private int total;

    @Autowired
    private ProductRepository productRepository;

    @Override
    // public List<Product> getAllProducts(Pageable pageable) {
    public Page <Product> getAllProducts(Pageable pageable) {
        // return productRepository.selectAllProducts(pageable);
        Integer total = productRepository.countAllProducts();
        List<Product> products;
        if (total > 0) {
            products = productRepository.selectAllProducts(pageable);
        } else {
            products = Collections.emptyList();
        }
        return new PageImpl<>(products, pageable, total);
    }



    @Override
    public List<Product> getProductsByCategory(Integer productCategoryId, Pageable pageable) {
        return productRepository.selectProductsByCategory(productCategoryId, pageable);
    }

    // ページネーションの実装
    // @Override
    // public Page<Product> selectProductsByPage(Integer productCategoryId, Pageable pageable) {
    //     // カテゴリIDが指定されていない場合は全商品を取得
    //     if (productCategoryId == null) {
    //         // 全商品の数を取得
    //         Integer total = productRepository.countAllProducts();
    //     } else {
    //         // カテゴリIDが指定されている場合はそのカテゴリの商品を取得
    //         Integer total = productRepository.countProductsByCategory(productCategoryId);
    //     }

    //     List<Product> products;

    //     if (total > 0) {
    //         products = productRepository.selectByPage(productCategoryId, pageable);
    //     } else {
    //         products = Collections.emptyList();
    //     }
    //     return new PageImpl<>(products, pageable, total);
    // }

}
