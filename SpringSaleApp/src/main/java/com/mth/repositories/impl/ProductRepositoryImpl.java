/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mth.repositories.impl;

import com.mth.pojo.Product;
import com.mth.repositories.ProductRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lenovo
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<Product> getProds(String cateId) {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Product",Product.class);
        // Nếu người dùng có click vào category (cateId != null)
        if (cateId != null && !cateId.isEmpty()) {
            // LƯU Ý: Chữ 'category' ở đây phải giống hệt tên biến @ManyToOne trong file POJO Product của bạn
            q = session.createQuery("FROM Product p WHERE p.categoryId.id c= :id",Product.class);
            q.setParameter("id", Integer.parseInt(cateId));
        }
        return q.getResultList();
    }
}
