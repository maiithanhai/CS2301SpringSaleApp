/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mth.controllers;

import com.mth.services.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mth.services.CategoryService;

/**
 *
 * @author lenovo
 */
@Controller
public class HomeController {

    @Autowired
    private CategoryService cate;
    @Autowired
    private ProductService prod;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("categories", this.cate.getCates());

        // Truyền cả Map params vào để tầng Repository tự soi xem có gì để lọc không
        model.addAttribute("products", this.prod.getProds(params));

        return "index";
    }
}
