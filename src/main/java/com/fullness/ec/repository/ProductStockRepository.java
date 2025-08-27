package com.fullness.ec.repository;

import org.apache.ibatis.annotations.Mapper;
import com.fullness.ec.entity.ProductStock;

@Mapper
public interface ProductStockRepository {

    void insert(Integer quantity);

    ProductStock selectByProductId(Integer productId);

    void insert(ProductStock stock);

}
