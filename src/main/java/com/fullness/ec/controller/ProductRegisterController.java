package com.fullness.ec.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fullness.ec.entity.Product;
import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.form.ProductForm;
import com.fullness.ec.helper.ProductHelper;
import com.fullness.ec.service.ProductCategoryResisterService;
import com.fullness.ec.service.ProductServiceResister;

@Controller
@RequestMapping("admin/product/register")
@SessionAttributes({ "productForm", "imageByte" })
public class ProductRegisterController {

    @Autowired
    private ProductServiceResister productService;
    @Autowired
    private ProductCategoryResisterService productCategoryService;
    @Autowired
    private ProductHelper productHelper;

    @ModelAttribute
    public ProductForm setupForm() {
        return new ProductForm();
    }

    @ModelAttribute("categories")
    public List<ProductCategory> categories() {
        return productCategoryService.getProductCategories();
    }

    /** 入力画面 */
    @GetMapping("input")
    public String input(Model model) {
        return "admin/product/register/input";
    }

    /** 入力画面の[完了]ボタンクリック → 確認画面 */
    @PostMapping("confirm")
    public String confirm(
            @Validated @ModelAttribute("productForm") ProductForm productForm,
            BindingResult result,
            Model model) throws IOException {
        if (result.hasErrors()) {
            return "admin/product/register/input";
        }
        ProductCategory productCategory = productCategoryService
                .getProductCategoryId(productForm.getProductCategoryId());
        model.addAttribute("categoryName", productCategory.getName());

        // 画像プレビュー用
        MultipartFile imageFile = productForm.getImageFile();
        if (imageFile != null && !imageFile.isEmpty()) {
            byte[] imageBytes = imageFile.getBytes();
            model.addAttribute("imageByte", imageBytes);
            model.addAttribute("image", ProductHelper.createBase64ImageString(imageFile));
        }

        return "admin/product/register/confirm";
    }

    /** 確認画面の[登録]ボタンクリック → 完了画面 */
    @PostMapping("execute")
    public String register(
            @ModelAttribute("productForm") ProductForm productForm,
            @ModelAttribute("imageByte") byte[] imageByte,
            RedirectAttributes ra) {

        // 画像ファイルを保存してファイル名をDBにセット
        if (imageByte != null) {
            String imageUrl = ProductHelper.uploadFile(
                    productForm.getImageFile().getOriginalFilename(),
                    imageByte);
            productForm.setImageUrl(imageUrl);
        }

        // Product product = productHelper.convertToProduct(productForm);

        productService.registerProduct(productForm);

        ra.addFlashAttribute("completed", true);
        return "redirect:/admin/product/register/complete";
    }

    /** 完了画面 */
    @GetMapping("complete")
    public String complete(ProductForm productForm, SessionStatus status, Model model) {
        if (!model.containsAttribute("completed")) {
            return "redirect:/admin/product/register/input";
        }
        model.addAttribute("addProductName", productForm.getName());
        status.setComplete();
        return "admin/product/register/complete";
    }

    /** 確認画面の[戻る]ボタンクリック */
    @PostMapping("input")
    public String back() {
        return "redirect:/admin/product/register/input";
    }
}