package com.fullness.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fullness.ec.entity.Product;
import com.fullness.ec.service.DeleteProductService;

@Controller
@RequestMapping("product/delete")
@SessionAttributes({ "product" })
public class DeleteProductController {
    @Autowired
    private DeleteProductService deleteProductService;

    /**
     * 商品IDに基づいて商品情報を取得するメソッド
     * 
     * @param id 商品ID
     * @return Productエンティティ
     */
    @GetMapping("/{productId}")
    public String deleteConfirmById(@PathVariable("productId") Integer id, Model model) {

        // System.out.println("商品Id = " + id);

        Product product = deleteProductService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
        model.addAttribute("productCategoryName", product.getProductCategory().getName());
        model.addAttribute("quantity", product.getStocks().getQuantity());
        model.addAttribute("imageUrl", product.getImageUrl());
        return "product/delete/confirm";
    }

    /**
     * 商品を理論削除するメソッド
     * 
     * @param id 理論削除する商品ID
     */
    @PostMapping()
    public String deleteProductById(@ModelAttribute("product") Product product) {
        deleteProductService.deleteProductById(product.getId());
        return "redirect:/product/delete/complete";
    }

    /**
     * 商品削除完了画面を表示するメソッド
     * 
     * @return 削除完了画面
     */
    @GetMapping("/complete")
    public String deleteComplete(@ModelAttribute("product") Product product, SessionStatus sessionStatus, Model model) {
        model.addAttribute("name", product.getName());
        sessionStatus.setComplete();
        return "product/delete/complete";
    }
}
