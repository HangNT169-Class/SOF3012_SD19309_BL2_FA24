package com.poly.hangnt169.B9_ScopeJspServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// wildcard => IMPORT TAT CA => THU VIEN CO BN HAM THI LAY BANG DAY
@WebServlet(name = "DemoServlet", value = "/DemoServlet")
public class DemoServlet extends HttpServlet {
    // CTRL ALT O => Fix import

    /**
     * Java 1 - public, protected, default, private => dong goi
     * access modifier (Pham vi truy cap cua bien/ham)
     * JSP/Servlet => request (yeu cau gui di) - Khach hang yeu cau den nha hang
     * =>  Scope trong jsp servlet
     * Scope trong JSP/Servlet
     * + Application
     * + Session
     * + Request
     * + Page
     * VD:
     * request.setAttribute(ts1,ts2)
     * session.setAttribute(ts1,ts2)
     * application.setAttribute(ts1,ts2)
     * component 1 - JSP 1                         component 3 - JSP 3
     *                          Pham vi truy cap
     * component 2 - JSP 2                         component 4 - JSP 4
     * Tat ca cac scope :
     * ts1: Ten bien ma duoc dung o jsp : String
     * ts2: Object - gia tri duoc truyen cho ts1 : String, 1 So, 1 Object, 1 List Object...
     * + Phia servlet :
     * <scope>.setAttribute(ts1,ts2)
     * <scope>.getAttribute(ts1)
     * <scope>.removeAttribute(ts1)
     * + Phia jsp: tenloaiscopeScope.ts1
     * VD: sessionScope.test , applicationScope.test...
     * 1. Request
     * => GIA TRI CUA BIEN REQUEST => CHI TON TAI TU SERVLET 1 -> JSP1
     * (CHI TON TAI GIA TRI 1 CHIEU)
     * => SERVLET 2 -> JSP2 ( KHONG TON TAI -> PHAI KHAI BAO REQUEST MOI)
     * NEU SERVLET ( KHONG CO ATTRIBUTE) => TUC LA K CO GIA TRI
     * 2. Page
     * => Tuong tu vs request ( GIA TRI CUC BO) => khong dung duoc o jsp khac servlet khac
     * => CHI GOI DUOC O JSP HIEN TAI
     * => LUU GIA TRI CUC BO
     * 3. Application:
     * - servlet1 -> jsp1
     * - Co the truyen tu servlet 2 -> jsp 2
     * => Giong bien toan cuc
     * => Thuong luu cache tren trinh duyet
     * Timeout (Thoi gian song cua scope): TON TAI MAI MAI DEN KHI NAO STOP SERVER
     * TABLE => CHI TIET (HAN CHE TOI DA CHOC SERVER => DB)
     * => RAT GIAU
     * for(choc DB=>)
     * table => chi tiet => getOne
     * B1: Kiem tra cache client -> cache => get. chua co -> choc server -> DB
     * => Giong bien cuc bo
     * 4. Sesssion:
     * - servlet1 -> jsp1
     * - co the truyen jsp 2 servlet2
     * => DUNG DE CHIA SE DU LIEU TOI CAC REQUEST HOAT DONG TRONG 1 PHIEN LAM VIEC
     * DEFAULT : 1 PHIEN : 30 PHUT
     * CAU HINH THOI GIAN SONG SESSSION => WEB.XML ( THOI GIAN TINH BANG PHUT)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message1", "Scope - JSP & Servlet - Request");
        // Goi application
        ServletContext application = getServletContext();
        application.setAttribute("message3", "Scope - JSP & Servlet - application");
        // Goi session
        HttpSession session = request.getSession();
        session.setAttribute("message4", "Scope - JSP & Servlet - session");
        request.getRequestDispatcher("/view/buoi9/demo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
