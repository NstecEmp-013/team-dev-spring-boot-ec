package com.fullness.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullness.ec.entity.Product;
import com.fullness.ec.repository.DeleteProductRepository;

@Service
public class DeleteProductServiceImpl implements DeleteProductService {
    @Autowired
    private DeleteProductRepository deleteProductRepository;

    @Override
    public Product getProductById(Integer id) {
        return deleteProductRepository.selectById(id);
    }

    @Override
    public void deleteProductById(Integer id) {
        deleteProductRepository.deleteById(id);
    }
}
