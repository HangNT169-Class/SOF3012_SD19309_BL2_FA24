package com.poly.hangnt169.B1_Hibernate.repository;

import com.poly.hangnt169.B1_Hibernate.entity.Product;
import com.poly.hangnt169.B1_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {
    private Session s;

    public ProductRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }
    public List<Product> getAll(){
        return s.createQuery("From Product ").list();
    }

    public static void main(String[] args) {
        System.out.println(new ProductRepository().getAll());
    }
}
