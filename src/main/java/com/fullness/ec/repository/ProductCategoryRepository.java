package com.fullness.ec.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.ProductCategory;

/**
 * 商品カテゴリテーブルをアクセスするリポジトリインターフェース
 */

@Mapper
public interface ProductCategoryRepository {

    void insert(ProductCategory category);

    List<ProductCategory> selectAll();

    ProductCategory selectById(Integer id);

    ProductCategory selectByName(String name);

    // ProductCategory getProductCategories();

}
