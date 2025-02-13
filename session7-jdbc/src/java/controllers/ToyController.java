/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import db.Brand;
import db.BrandFacade;
import db.Toy;
import db.ToyFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PHT
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
        String action = (String)request.getAttribute("action");
        //System.out.println("action: " + action);
        switch(action){
            case "index":
                index(request, response);
                break;
            case "create":
                //hiện create form
                create(request, response);
                break;
            case "create_handler":
                //xử lý create form
                create_handler(request, response);
                break;
            case "delete":
                //hiện delete form
                delete(request, response);
                break;
            case "delete_handler":
                //xử lý delete form
                delete_handler(request, response);
                break;
            case "edit":
                //hiện edit form
                edit(request, response);
                break;
            case "edit_handler":
                //xử lý edit form
                edit_handler(request, response);
                break;
        }    
    }
    
    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {            
            //đọc table Toy
            ToyFacade tf = new ToyFacade();
            List<Toy> list = tf.select();
            //lưu list vào request
            request.setAttribute("list", list);
            //forward request & response cho view /toy.jsp xử lý tiếp
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {       
            //đọc table brand
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
            //truyền list cho view để tạo combobox
            request.setAttribute("list", list);
            //cho hiện view
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {                      
            String op = request.getParameter("op");
            switch(op){
                case "create":
                    //lấy thông tin từ client
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    double  price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    String brand = request.getParameter("brand");
                    //tạo đối tượng toy
                    Toy toy = new Toy();
                    toy.setId(id);
                    toy.setName(name);
                    toy.setPrice(price);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    toy.setExpDate(sdf.parse(expDate));
                    toy.setBrand(brand);
                    //insert data vào db
                    ToyFacade tf = new ToyFacade();
                    tf.create(toy);
                case "cancel":
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);
                    request.getRequestDispatcher("/toy/index.do").forward(request, response);
                    break;
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't insert a new toy.");
            //cho hiện lại create form
            request.getRequestDispatcher("/toy/create.do").forward(request, response);
        }
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {                      
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {     
            String op = request.getParameter("op");
            switch(op){
                case "yes":
                    String id = request.getParameter("id");
                    //Xóa toy
                    ToyFacade tf = new ToyFacade();
                    tf.delete(id);
                case "no":
                    //cho hiện danh sách toy (chạy lại case index)
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);
                    request.getRequestDispatcher("/toy/index.do").forward(request, response);
                    break;                            
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {         
            String id = request.getParameter("id");
            //đọc toy từ db
            ToyFacade tf = new ToyFacade();
            Toy toy = tf.read(id);
            //lưu toy vào request để truyền cho view
            request.setAttribute("toy", toy);
            //đọc table brand
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
            //truyền list cho view để tạo combobox
            request.setAttribute("list", list);
            //cho hiện view edit.jsp
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    protected void edit_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {         
            String op = request.getParameter("op");
            switch(op){
                case "update":
                    //lấy thông tin từ client
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    double  price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    String brand = request.getParameter("brand");
                    //tạo đối tượng toy
                    Toy toy = new Toy();
                    toy.setId(id);
                    toy.setName(name);
                    toy.setPrice(price);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    toy.setExpDate(sdf.parse(expDate));
                    toy.setBrand(brand);
                    //update data vào db
                    ToyFacade tf = new ToyFacade();
                    tf.update(toy);
                case "cancel":
                    //cho hiện danh sách toy (chạy lại case index)
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);
                    request.getRequestDispatcher("/toy/index.do").forward(request, response);
                    break;
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't update toy data.");
            //cho hiện lại view edit.jsp
            //edit(request, response);
            request.getRequestDispatcher("/toy/edit.do").forward(request, response);
        }
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
