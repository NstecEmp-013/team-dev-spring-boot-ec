package com.fullness.ec.repository;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.Product;

@Mapper
public interface DeleteProductRepository {

    /**
     * 指定された商品IDの商品情報を取得するメソッド
     * 
     * @param id 商品ID
     * @return Productエンティティ
     */
    Product selectById(Integer id);

    /**
     * 商品を削除するメソッド
     * 
     * @param id 削除する商品ID
     * @return
     */
    void deleteById(Integer id);
}
