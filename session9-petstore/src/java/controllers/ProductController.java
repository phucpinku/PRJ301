/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Product;
import db.productFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

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
        String action = (String)request.getAttribute("action");
        //System.out.println("action: " + action);
        switch(action){
            case "index":
                index(request, response);
                break;
        }    
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {            
            int pageSize = 6;
            //lay tham so page
            String spage = request.getParameter("page");
            int page = (spage==null) ? 1:Integer.parseInt(spage);
            if (page < 1) {
                page = 1;
            }
            //luu page vao request
            request.setAttribute("page", page);
            //đọc table Toy
            productFacade pf = new productFacade();
            List<Product> list = pf.select(page, pageSize);
            //tinh totalPage
            int rowCount = pf.count();
            int totalPage =(int)Math.ceil(rowCount / pageSize);
            //luu totalPage vao request
            request.setAttribute("totalPage", totalPage);
            //lưu list vào request
            request.setAttribute("list", list);
            //forward request & response cho view /toy.jsp xử lý tiếp
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
