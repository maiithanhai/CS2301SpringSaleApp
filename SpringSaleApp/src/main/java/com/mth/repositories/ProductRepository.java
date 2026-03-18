/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mth.repositories;

import com.mth.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lenovo
 */
public interface ProductRepository {
    List<Product> getProds(Map<String,String> params);
    void addOrUpdateProduct(Product p);
}
