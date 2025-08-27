package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStock {
    private Integer id;
    private Integer quantity;
    private Integer productId;
}
