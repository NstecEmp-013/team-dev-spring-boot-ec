package com.fullness.ec.form;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm implements Serializable {

    private Integer id;

    /** 商品名 */
    @NotBlank(message = "{productForm.name.placeholder}")
    @Pattern(regexp = "^$|^[一-龯ぁ-んァ-ン　ー]+$", message = "{productForm.name.pattern}")
    private String name;

    /** 価格 */
    @NotNull
    @Min(1)
    @Max(1000000)
    private Integer price;

    /** 在庫数 */
    @NotNull
    @Min(1)
    @Max(1000)
    private Integer quantity;

    /** カテゴリID */
    @NotNull(message = "{productForm.productCategoryId.placeholder}")
    private Integer productCategoryId;

    /** 画像ファイル */
    @NotNull(message = "{productForm.imageUrl.placeholder}")
    private MultipartFile imageFile;

    /** 保存後の画像ファイル名（DB用） */
    private String imageUrl;

}
