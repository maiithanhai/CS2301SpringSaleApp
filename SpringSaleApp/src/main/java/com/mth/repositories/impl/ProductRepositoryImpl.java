/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mth.repositories.impl;

import com.mth.pojo.Product;
import com.mth.repositories.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
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
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Product> getProds(Map<String,String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);

        if (params != null) {
            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) {
                // Chỉ thêm điều kiện lọc nếu cateId KHÔNG null
                Predicate p = b.equal(root.get("category").get("id"), Integer.parseInt(cateId));
                q.where(p);
            }
        }

        return session.createQuery(q).getResultList();
    }

    @Override
    public void addOrUpdateProduct(Product p) {
        Session session = this.factory.getObject().getCurrentSession();
        if (p.getId()!=null){
            session.merge(p);
        }
        else {
            session.persist(p);
        }
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
