package com.fullness.ec.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.Product;

/**
 * 商品テーブルをアクセスするリポジトリインターフェース
 */

@Mapper
public interface ProductRepository {

    List<Product> selectAll();

    void insert(Product product);

}
