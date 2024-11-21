package com.poly.hangnt169.B10_Filter.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {
        "/login",
        "/dang-xuat"
})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("login")){
            request.getRequestDispatcher("/view/buoi10/login.jsp").forward(request, response);
        }else{
            // dang xuat
            // xoa session
            // C1: Xoa lan luot
            HttpSession session = request.getSession();
//            session.removeAttribute("uname");
//            session.removeAttribute("role1");
            // C2: Xoa tat ca
            session.invalidate(); // localstorge
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("u1");
        String password = request.getParameter("p1");
        if ((username.equalsIgnoreCase("hangnt169") &&
                password.equals("123456"))
                ||
                (username.equalsIgnoreCase("nguyenvv4") &&
                        password.equals("1234567"))
        ) {
            //thanh cong
            HttpSession session = request.getSession();
            session.setAttribute("uname", username);
            // xet them role
            if (username.equalsIgnoreCase("HangNT169")) {
                session.setAttribute("role1", "Admin");
            } else {
                session.setAttribute("role1", "NhanVien");
            }
            response.sendRedirect("/category/hien-thi");
//            request.getRequestDispatcher("/view/buoi10/ket-qua.jsp").forward(request, response);
        } else {
            request.setAttribute("erro", "Tai khoan hoac mat khau khong dung");
            request.getRequestDispatcher("/view/buoi10/login.jsp").forward(request, response);
        }
    }
}
