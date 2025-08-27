package com.fullness.ec.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.ProductCategory;

@Mapper
public interface ProductCategoryRepository {

    List<ProductCategory> selectAllProductCategories();

}
