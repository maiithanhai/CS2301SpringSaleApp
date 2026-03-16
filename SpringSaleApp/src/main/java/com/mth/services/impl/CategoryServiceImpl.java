/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mth.services.impl;

import com.mth.pojo.Category;
import com.mth.repositories.CategoryRepository;
import com.mth.services.CategorySevice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanhai7425
 */
@Service
public class CategoryServiceImpl implements CategorySevice{
    @Autowired
    private CategoryRepository cateRepo;
    @Override
    public List<Category> getCates() {
        return this.cateRepo.getCates(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
