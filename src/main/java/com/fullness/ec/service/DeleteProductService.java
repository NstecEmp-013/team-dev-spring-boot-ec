package com.fullness.ec.service;

import com.fullness.ec.entity.Product;

public interface DeleteProductService {
    /**
     * 商品IDに基づいて商品情報を取得するメソッド
     *
     * @param id 商品ID
     * @return Productエンティティ
     */
    Product getProductById(Integer id);

    /**
     * 商品を理論削除するメソッド
     *
     * @param id 理論削除する商品ID
     */
    void deleteProductById(Integer id);
}
