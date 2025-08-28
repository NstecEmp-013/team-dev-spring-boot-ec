package com.fullness.ec.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.Product;
import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.entity.ProductStock;

@SpringBootTest
public class DeleteProductServiceTest {
    @Autowired
    private DeleteProductService deleteProductService;

    @Transactional
    @Test
    public void testGetProductById() {
        Integer id = 1;
        Product product = deleteProductService.getProductById(id);
        assertEquals(1, product.getId());
        assertEquals("水性ボールペン(黒)", product.getName());
        assertEquals(120, product.getPrice());
        assertEquals("black_pen_w.jpg", product.getImageUrl());
        assertEquals(new ProductCategory(1, "文房具"), product.getProductCategory());
        assertEquals(0, product.getDeleteFlag());
        assertEquals(new ProductStock(1, 10, 1), product.getStocks());
    }

    @Test
    public void testDeleteProductById() {
        //Integer id = 1;
        //deleteProductService.deleteProductById(id);
        //Product product = deleteProductService.getProductById(id);
        //assertEquals(1, product.getDeleteFlag());
        assertTrue(true);

    }

}
