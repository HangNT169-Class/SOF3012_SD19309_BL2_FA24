package com.poly.hangnt169.B1_Hibernate.servlet;

import com.poly.hangnt169.B1_Hibernate.entity.Category1;
import com.poly.hangnt169.B1_Hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = {
        // LIET KE TAT CA CAC DUONG DAN
        "/category/hien-thi", // GET
        "/category/detail",   // GET
        "/category/delete",  // GET
        "/category/view-update", // GET
        "/category/update", // POST
        "/category/view-add",   // GET
        "/category/add", // POST
        "/category/search" // GET
})
/**
 * WebServlet:
 *  +Name:k bat buoc
 *  + Value: Bat buoc
 *      => chua duong dan ( CHUA TAT CA CAC DUONG DAN CUA DE BAI)
 *  Duong dan:
 *      + Duong dan bat dau /
 *      + Duong dan la duy nhat (Unique)
 */ public class CategoryServlet extends HttpServlet {
    /**
     * BE & FE : trao doi thong qua phuong thuc HTTP
     * => GET, POST, PUT, DELETE
     * => J3 & J4 & J5: GET & POST
     * GET: Lay, Hien thi...
     * POST: Xu ly form
     */
    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // liet ke cac chuc nang cua 6 thang
        // http:/localhost:8080/abc => URL  => StringBuffer
//        StringBuffer url = request.getRequestURL();
//        System.out.println(url);
//        https://classroom.google.com/u/0/w/NzI3MDkxMTA4MjE2/t/all
        // Java: http
        // Phuong thuc trao doi + domain+path+uri
        // B1:Lay ra uri cua duong dan
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("hien-thi")) {
            // hien thi du lieu
            this.hienThiCate(request, response);
        } else if (uri.contains("detail")) {
//            detail
            this.detailsCate(response, request);
        } else if (uri.contains("delete")) {
//            delete
            this.deleteCate(request, response);
        } else if (uri.contains("view-update")) {
//            view update
            this.viewUpdateCate(request, response);
        } else if (uri.contains("view-add")) {
//            view add
            this.viewAddCate(request, response);
        } else {
//            search
            this.searchCate(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 2 thang
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
//            form update
            this.updateCate(request, response);
        } else {
//            form add
            this.addCate(request, response);
        }
    }

    private void addCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailsCate(HttpServletResponse response, HttpServletRequest request) {
    }

    private void hienThiCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: repo => lay ra tat ca category list
        List<Category1> a1 = categoryRepository.getAll();
        // B2:Day list => jsp => request.setAttribute
        request.setAttribute("listCategory", a1);
        // B3: Chuyen trang
        request.getRequestDispatcher("/view/buoi1/categorys.jsp").forward(request,response);
    }

}
