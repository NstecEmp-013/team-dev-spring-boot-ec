package com.fullness.ec.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fullness.ec.entity.Product;
import com.fullness.ec.entity.ProductStock;
import com.fullness.ec.form.ProductForm;

@Component
public class ProductHelper {

    public Product convertToProduct(ProductForm form) {
        Product product = new Product();
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setProductCategoryId(form.getProductCategoryId());
        product.setImageUrl(form.getImageUrl());
        return product;
    }

    public ProductStock convertToStock(Product product, ProductForm form) {
        ProductStock stock = new ProductStock();
        stock.setProductId(product.getId()); // Product登録後のID
        stock.setQuantity(form.getQuantity());
        return stock;
    }

    /**
     * 画像ファイルをBase64エンコードした文字列を生成します。
     * 
     * @param file 画像ファイル
     * @return Base64エンコードした文字列
     */

    public static String createBase64ImageString(MultipartFile file) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("data:image/");
            sb.append(file.getContentType().split("/")[1]);
            sb.append(";base64,");
            sb.append(Base64.getEncoder().encodeToString(file.getBytes()));
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("画像のBase64エンコードに失敗しました。", e);
        }
    }

    /**
     * 画像ファイルをサーバーに保存します。
     * 
     * @param fileName  保存するファイル名
     * @param fileBytes 画像ファイルのバイト列
     * @return 保存先のパス
     */

    public static String uploadFile(String fileName, byte[] fileBytes) {
        // 元のファイル名から拡張子を取得
        String uuidFileName = UUID.randomUUID().toString() + fileName;
        String filePath = new File("plan/img").getAbsolutePath() + File.separator + uuidFileName;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
            fos.write(fileBytes);
            return uuidFileName;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("画像の保存先フォルダが見つかりません。", e);
        } catch (IOException e) {
            throw new RuntimeException("画像の保存に失敗しました。", e);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("ファイルのクローズに失敗しました。", e);
            }
        }
    }
}
