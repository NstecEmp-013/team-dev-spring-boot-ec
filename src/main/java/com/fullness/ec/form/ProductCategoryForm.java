package com.fullness.ec.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryForm implements Serializable {

    /** カテゴリ名 */
    @NotBlank(message = "{productCategoryForm.name.placeholder}")
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^$|^[一-龯ぁ-んァ-ン　ー]+$")
    private String name;
}
