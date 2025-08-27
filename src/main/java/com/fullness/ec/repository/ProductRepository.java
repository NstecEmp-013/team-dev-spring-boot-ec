package com.fullness.ec.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fullness.ec.entity.Product;

@Mapper
public interface ProductRepository {

    List<Product> selectAllProducts(Pageable pageable);

    // List<Product> selectProductsByCategory(@RequestParam(value = "productCategoryId") Integer productCategoryId, Pageable pageable);
    List<Product> selectProductsByCategory(@RequestParam(value = "productCategoryId") Integer productCategoryId, Pageable pageable);
    // ページネーション
    Integer countAllProducts();
    Integer countProductsByCategory(@Param("productCategoryId") Integer productCategoryId);
    // List<Product> selectByPage(@Param("pageable") Integer productCategoryId, Pageable pageable);

    Product selectById(Integer productCategoryId);

}