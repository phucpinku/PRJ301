/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Account;
import db.AccountFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
@WebServlet(name = "AccountController", urlPatterns = {"/account"})
public class AccountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = (String) request.getAttribute("action");
        //System.out.println("action: " + action);
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // lay thong tin tu client
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            // kiem tra login
            AccountFacade af = new AccountFacade();
            Account account = af.login(email, password);
            if (account != null) {
                //neu login thanh cong
                //lay tham chieu cua doi tuong session
                HttpSession session = request.getSession();
                //luu account vao session
                session.setAttribute("account", account);
            } else {
//                        //neu login khong thanh cong
//                        //truyen thong bao loi cho trang login
//                        request.setAttribute("message", "Please check your email and password. ");
//                        //cho hien lai trang login
//                        request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            request.getRequestDispatcher("/").forward(request, response);
        } catch (Exception e) {
            // in chi tiet loi
            e.printStackTrace();
            //truyen thong bao loi cho view
            request.setAttribute("message", e.getMessage());
            //cho hien lai trang login
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //lay tham chieu cua doi tuong session
        HttpSession session = request.getSession();
        //huy session
        session.invalidate();
        //cho hien home page
        request.getRequestDispatcher("/").forward(request, response);
    }
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
