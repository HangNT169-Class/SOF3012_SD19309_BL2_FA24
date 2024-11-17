package com.poly.hangnt169.B9_ScopeJspServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// wildcard => IMPORT TAT CA => THU VIEN CO BN HAM THI LAY BANG DAY
@WebServlet(name = "Dem1oServlet", value = "/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message1", "Gia tri cua Servlet khac");
        // Lay gia tri session phia ben servlet
        HttpSession session = request.getSession();
        String str1 = (String) session.getAttribute("message4");
        // SS DB => tk toan tai
        // xy ly
        request.setAttribute("str12", str1+"test");
        request.getRequestDispatcher("/view/buoi9/demo1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
