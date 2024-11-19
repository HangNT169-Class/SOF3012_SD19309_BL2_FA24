package com.poly.hangnt169.B1_Hibernate.servlet;

import com.poly.hangnt169.B1_Hibernate.entity.Product;
import com.poly.hangnt169.B1_Hibernate.repository.ProductRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {"/product/hien-thi"
})
public class ProductServlet extends HttpServlet {
    private ProductRepository rp = new ProductRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.hienThi(request,response);
        }

    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list= rp.getAll();
        request.setAttribute("listProduct",list);
        request.getRequestDispatcher("/view/buoi1/products.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
