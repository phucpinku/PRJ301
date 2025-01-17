/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Toy;
import db.ToyFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ToyController", urlPatterns = {"/toy"})
public class ToyController extends HttpServlet {

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
        String action = request.getParameter("action");
        switch (action) {
            case "index":
                index(request, response);
                break;
            case "create":
                //show create form
                create(request, response);
                break;
            case "create_handler":
                //execute create form
                create_handler(request, response);
                break;
            case "delete":
                //show delete form
                delete(request, response);
                break;
            case "delete_handler":
                //execute delete form
                delete_handler(request, response);
                break;
        }
        try {

            ToyFacade tf = new ToyFacade();
            List<Toy> list = tf.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/toy.jsp").forward(request, response);
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

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            ToyFacade tf = new ToyFacade();
            List<Toy> list = tf.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/toy.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("/create.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch(op) {
                case "create":
                    //take infor from client
                    String id = request.getParameter("id");
                    String name= request.getParameter("name");
                    double price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    String brand = request.getParameter("brand");
                    //create object Toy
                   // Toy toy = new Toy(id, name, price, expDate, brand);
                    Toy toy = new Toy();
                    toy.setId(id);
                    toy.setName(name);
                    toy.setPrice(price);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    toy.setExpDate(sdf.parse(expDate));
                    toy.setBrand(brand);
                    //insert data to db
                    ToyFacade tf = new ToyFacade();
                    tf.create(toy);
                    
                case "cancel":
                    //Cach 1request.getRequestDispatcher("/index.jsp").forward(request, response);
                    request.getRequestDispatcher("/toy?action=index").forward(request, response);
                    break;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't insert a new toy.");
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("/delete.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
