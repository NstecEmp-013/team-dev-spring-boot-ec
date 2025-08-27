package com.fullness.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fullness.ec.entity.Product;
import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.service.ProductCategoryService;
import com.fullness.ec.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public String getProducts(
        @RequestParam(value = "productCategoryId", required = false) Integer productCategoryId, 
        Model model, @PageableDefault(page=0, size=10)Pageable pageable) {
        
        List<ProductCategory> allCategories = productCategoryService.getAllCategories();
        model.addAttribute("allcategories", allCategories);

        List<Product> searchResult;

    

        if (productCategoryId == null) {

            //List<Product> allProducts = productService.getAllProducts(pageable);
            Page<Product> products = productService.getAllProducts(pageable);
            List<Product> allProducts = products.getContent();
            searchResult = allProducts;

            model.addAttribute("pageUrl", "/admin/product?");
            model.addAttribute("products",products);
            model.addAttribute("next",pageable.getPageNumber()+2);
            model.addAttribute("prev",pageable.getPageNumber());

        } else {
            List<Product> selectedProductsByCategory = productService.getProductsByCategory(productCategoryId, pageable);
            searchResult = selectedProductsByCategory;

        }
        model.addAttribute("searchResult", searchResult);

        // ページネーションのための情報をモデルに追加
        // Page<Product>products = productService.selectProductsByPage(productCategoryId, pageable);
        // model.addAttribute("pageUrl", "/admin/product?");
        // model.addAttribute("products",products);
        // model.addAttribute("next",pageable.getPageNumber()+2);
        // model.addAttribute("prev",pageable.getPageNumber());


        return "admin/product/product";
    }

}

