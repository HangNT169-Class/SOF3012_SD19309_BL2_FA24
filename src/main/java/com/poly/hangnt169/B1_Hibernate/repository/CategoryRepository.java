package com.poly.hangnt169.B1_Hibernate.repository;

import com.poly.hangnt169.B1_Hibernate.entity.Category1;
import com.poly.hangnt169.B1_Hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
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

    public Category1 getOne2(Long id) {
        // B1: Tao cau lenh hql
//        String hql = "SELECT cate FROM Category1 cate WHERE id1 = ?1";
        String hql = "SELECT cate FROM Category1 cate WHERE id1 = :a1";
        // B2: Tao cau len query
        Query query = s.createQuery(hql);
//        query.setParameter(1, id);
        query.setParameter("a1", id);
        // B3: Khoi tao doi tuong
        Category1 cate = (Category1) query.getSingleResult(); // Tra doi tuong ket qua duy nhat
        return cate;
    }

    // sort -> tu lam
    // search
    public List<Category1> searchName(String name) {
        String hql = "SELECT cate FROM Category1 cate WHERE categoryName LIKE :a1";
        Query query = s.createQuery(hql);
        query.setParameter("a1", "%" + name + "%");
        return query.getResultList(); // tra ve ca ds tim thay
    }

    /**
     * -- giai thich ham nay la gi lam gi
     *
     * @param pageNo:   gt gia tri cua bien nay: so Trang (trang so 1, trang 2..)
     * @param pageSize: so luong phan tu trong 1 trang
     * @return : gt gia tri tra ve
     */
    public List<Category1> phanTrangSQl(Integer pageNo, Integer pageSize) {
        // TRANG DAU TIEN BAT DAU BANG 0
        Integer offset1 = pageNo * pageSize;
        // B1: Tao cau lenh SQL
//        String sql = "SELECT * from category " +
//                "ORDER BY id  " +
//                "OFFSET :offset ROWS \n" +
//                "FETCH NEXT :pageSize1 ROWS ONLY ";
            String sql = """
               select * from category
              ORDER BY id
              OFFSET :offset ROWS
              FETCH NEXT :pageSize1 ROWS ONLY;
            """;
//        String sql1="select * from category\n" +
//                "ORDER BY id \n" +
//                "OFFSET9 ROWS \n" +
//                "FETCH NEXT 3 ROWS ONLY ";
        // B2: Tao query
        Query query = s.createNativeQuery(sql, Category1.class);
        // B3: Set value
        query.setParameter("offset",offset1);
        query.setParameter("pageSize1",pageSize);
        return  query.getResultList();
    }

    public List<Category1>phanTrangHQl(Integer pageNo, Integer pageSize){
        int offset = pageNo * pageSize;
        String hql = """
                SELECT cate FROM Category1 cate  
                ORDER BY cate.id1
                """;
        Query query = s.createQuery(hql);
        query.setFirstResult(offset); // NGANG HANG VS OFFSET => KET QUA TRA RA LA +1
        query.setMaxResults(pageSize); // SO LUONG MAX/TRANG
        return  query.getResultList();
    }
    public static void main(String[] args) {
//        System.out.println(new CategoryRepository().getOne2(1L));
        System.out.println(new CategoryRepository().phanTrangHQl(1,4));
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

}
