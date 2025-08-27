package com.fullness.ec.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.Product;

@Mapper
public interface ProductResisterRepository {

    List<Product> selectAll();

    void insert(Product product);

}
