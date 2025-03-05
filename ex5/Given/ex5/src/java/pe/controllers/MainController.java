    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package pe.controllers;

    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.List;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import pe.car.CarDAO;
    import pe.car.CarDTO;
    import pe.user.UserDAO;
    import pe.user.UserDTO;

    /**
     *
     * @author hd
     */
    public class MainController extends HttpServlet {

        private static final String ERROR = "error.jsp";

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                String url = ERROR;
                try {
    //                your code here
                    String action = request.getParameter("action");
                    System.out.println("action: " + action);
                    switch (action) {
                        case "login":
                            url = login(request, response);
                            break;
                        case "logout":
                            url = logout(request, response);
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
        }

        protected String login(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String url = "login.jsp";
            try {
                String op = request.getParameter("op");
                switch (op) {
                    case "login":
                        String userID = request.getParameter("userID");
                        String password = request.getParameter("password");
                        UserDAO uf = new UserDAO();
                        UserDTO user = uf.login(userID, password);

                        if (user != null) {

                            HttpSession session = request.getSession();

                            session.setAttribute("user", user);

                            url = "carList.jsp";

                            carList(request, response);
                        } else {
                            throw new Exception("Incorrect userID or password");
                        }
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                request.setAttribute("message", "Incorrect userID or password");
            }
            return url;
        }

        protected void carList(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            try {
                CarDAO cf = new CarDAO();
                List<CarDTO> list = cf.select();

                HttpSession session = request.getSession();
                session.setAttribute("list", list);

            } catch (Exception ex) {
                ex.printStackTrace();
                request.setAttribute("message", "Error reading employees table");
            }
        }

        protected String logout(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String url;
            HttpSession session = request.getSession();
            //huy session
            session.invalidate();
            return "login.jsp";
        }

        protected String create(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession();
            String url = "login.jsp";

            UserDTO user = (UserDTO) session.getAttribute("user");

            if (user.getRoleID().equals("AD")) {
                url = "create.jsp";
            }

            return url;
        }

        protected String create_handler(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession();
            String url = "carList.jsp";

            try {
                String op = request.getParameter("op");
                switch (op) {
                    case "create":
                        String id = request.getParameter("id");
                        String name = request.getParameter("name");
                        String description = request.getParameter("description");
                        double price = Double.parseDouble(request.getParameter("price"));
                        int speed = Integer.parseInt(request.getParameter("speed"));
                        boolean status = true;

                        String errorMessage = null;

                        // check price
                        if (price >= 100.0 && price <= 10000.0) {
                            //
                        } else {
                            errorMessage = "The price field must be between 100 and 10000 and can have one digit in the decimal part";
                        }
                        if (errorMessage != null) {
                            request.setAttribute("message", errorMessage);
                            url = "carList.jsp";
                            break;
                        }
                        //check speed
                        if (speed >= 100 && price <= 10000) {
                            //
                        } else {
                            errorMessage = "The speed field must be between 100 and 10000 and catn have any digit in the decimal part";
                        }
                        if (errorMessage != null) {
                            request.setAttribute("message", errorMessage);
                            url = "carList.jsp";
                            break;
                        }

                        CarDAO cf = new CarDAO();
                        cf.create(id, name, description, price, speed, status);

                        url = "carList.jsp";
                        break;
                    case "cancel":
                        url = "carList.jsp";
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                request.setAttribute("message", ex);
            }

            carList(request, response);
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
