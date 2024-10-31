package com.poly.hangnt169.B1_Hibernate.repository;

import com.poly.hangnt169.B1_Hibernate.entity.Category1;
import com.poly.hangnt169.B1_Hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // CRUD : La tang trao doi truc tiep vs DB
    // Mo cong ket noi
    // J3: Connection
    // J4: Session
    // Mo 1 PHIEN DUY NHAT
    private Session s;

    public CategoryRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    // Select => READ
    public List<Category1> getAll() {
        return s.createQuery("FROM Category1").list();
    }

    // Detail
    public Category1 getOne(Long id) {
        return s.find(Category1.class, id);
    }

    // Them/ Sua/Xoa
    // transation
    public void add(Category1 cate) {
        try {
            // B1: Lay transion hien tai de bat dau
            s.getTransaction().begin();
            ;
            // B2: Them/Sua/Xoa
            // Them : save / saveOrUpdate/ persit
            s.persist(cate);
            // B3: Day du lieu di
            s.getTransaction().commit();
        } catch (Exception e) {
            // rollback lai du lieu
            s.getTransaction().rollback();
        }
    }

    public void update(Category1 cate) {
        try {
            // B1: Lay transion hien tai de bat dau
            s.getTransaction().begin();
            ;
            // B2: Them/Sua/Xoa
            // Update :  saveOrUpdate/ merge
            s.merge(cate);
            // B3: Day du lieu di
            s.getTransaction().commit();
        } catch (Exception e) {
            // rollback lai du lieu
            s.getTransaction().rollback();
        }
    }

    public void delete(Category1 cate) {
        try {
            // B1: Lay transion hien tai de bat dau
            s.getTransaction().begin();
            ;
            // B2: Them/Sua/Xoa
            // Delete : delete
            s.delete(cate);
            // B3: Day du lieu di
            s.getTransaction().commit();
        } catch (Exception e) {
            // rollback lai du lieu
            s.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getOne(1L));
    }
}
