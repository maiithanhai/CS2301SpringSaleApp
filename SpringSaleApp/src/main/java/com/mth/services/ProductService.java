/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mth.services;

import com.mth.pojo.Product;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface ProductService {
    List<Product> getProds(String cateId);
    void addOrUpdateProduct(Product p);
}
