/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mth.controllers;

import com.mth.services.CategorySevice;
import com.mth.services.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lenovo
 */
@Controller
public class HomeController {
    @Autowired
    private CategorySevice cate;
    @Autowired
    private ProductService prod;
    @RequestMapping("/")
    public String index(Model model,@RequestParam Map<String,String> params){
        String cateId = params.get("cateId");
        model.addAttribute("categories",this.cate.getCates());
        model.addAttribute("products",this.prod.getProds(cateId));
        return "index";
    }
}
