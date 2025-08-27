package com.fullness.ec.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockForm implements Serializable {

    @NotBlank
    @Size(min = 1, max = 1000)
    private Integer quantity;

}
