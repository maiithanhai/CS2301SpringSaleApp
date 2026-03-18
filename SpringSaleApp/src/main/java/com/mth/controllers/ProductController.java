/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mth.controllers;

import com.mth.pojo.Product;
import com.mth.repositories.CategoryRepository;
import com.mth.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author thanhai7425
 */
@Controller
public class ProductController {
    @Autowired
    private CategoryRepository cate;
    @Autowired
    private ProductService prod;
    @GetMapping("/products")
    public String productView(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("categories",this.cate.getCates());
        return "products";
    }
}
