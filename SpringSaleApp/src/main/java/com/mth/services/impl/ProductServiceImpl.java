/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mth.services.impl;

import com.mth.pojo.Product;
import com.mth.repositories.ProductRepository;
import com.mth.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lenovo
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository prodRepo;
    @Override
    public List<Product> getProds(String cateId) {
        return this.prodRepo.getProds(cateId);
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addOrUpdateProduct(Product p) {
        this.prodRepo.addOrUpdateProduct(p); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
