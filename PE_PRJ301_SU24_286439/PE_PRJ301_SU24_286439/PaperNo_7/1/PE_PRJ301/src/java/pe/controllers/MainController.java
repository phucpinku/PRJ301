package pe.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.account.AccountDAO;
import pe.account.AccountDTO;
import pe.appointment.AppointmentDAO;
import pe.appointment.AppointmentDTO;

public class MainController extends HttpServlet {

    private static final String ERROR = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            //your code here
            String action = request.getParameter("action");
            System.out.println("action: " + action);
            switch (action) {
                case "login":
                    url = login(request, response);
                    break;
                case "create":
                    url = create(request, response);
                    break;
                case "create_handler":
                    url = create_handler(request, response);
                    break;
            }

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    protected String login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "login.jsp";
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "login":
                    String account = request.getParameter("account");
                    String pass = request.getParameter("pass");
                    AccountDAO af = new AccountDAO();
                    AccountDTO acc = af.login(account, pass);

                    if (acc != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("account", acc);
                        url = "appointments.jsp";
                        appointmentList(request, response);
                    } else {
                        throw new Exception("Incorrect account or Password");
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    protected void appointmentList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AppointmentDAO af = new AppointmentDAO();
            List<AppointmentDTO> list = af.select();

            HttpSession session = request.getSession();
            session.setAttribute("list", list);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Error reading employees table");
        }
    }

    protected String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        return "login.jsp";
    }

    protected String create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = "login.jsp";
        AccountDTO acc = (AccountDTO) session.getAttribute("account");
        if (acc.getRoleDB().equals("super")) {
            url = "create.jsp";
        }
        return url;
    }

    protected String create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = "create.jsp";
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    String account = request.getParameter("account");
                    String partnerPhone = request.getParameter("partnerPhone");
                    String partnerName = request.getParameter("partnerName");
                    String stimeToMeet = request.getParameter("timeToMeet");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date timeToMeet = Date.valueOf(stimeToMeet);
                    String place = request.getParameter("place");
                    double expense = Double.parseDouble(request.getParameter("expense"));
                    String note = request.getParameter("note");
                    String errorMessage = null;
                    if (account != null) {
                        
                    } else {
                        errorMessage = "account must not be left blank";
                    }
                    if (timeToMeet == null || stimeToMeet == null) {
                        errorMessage = "time to meet must not be left blank";
                    }
                    if (partnerName == null) {
                        errorMessage = "name must not be left blank";
                    }
                    if (partnerPhone == null) {
                        errorMessage = "phone must not be left blank";
                    }
                        
                    if (errorMessage != null) {
                        request.setAttribute("message", errorMessage);
                        url = "create.jsp";
                        break;
                    }
                    AppointmentDAO ad = new AppointmentDAO();
                    ad.create(account, partnerPhone,partnerName, timeToMeet, place, expense, note);
                    url = "appointments.jsp";
                    break;
                case "cancel":
                    url = "appointments.jsp";
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        appointmentList(request, response);
        return url;
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
