/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.utils.HouseDAO;
import pe.utils.HouseDTO;
import pe.utils.UserDAO;
import pe.utils.UserDTO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";
    private static final String LIST = "houseList.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOGIN_PAGE;
            }

//            your code here
            switch (action) {
                case "login":
                    url = login(request, response);
                    break;
                case "logout":
                    url = logout(request, response);
                    break;
                case "search":
                    url = search(request, response);
                    break;
                case "delete":
                    url = delete(request, response);
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
        try {

            String userID = request.getParameter("userID").trim();
            String password = request.getParameter("password").trim();

            UserDAO ud = new UserDAO();
            UserDTO user = ud.login(userID, password);

            if (user != null) {
                HttpSession session = request.getSession();

                session.setAttribute("user", user);

                houseList(request, response);

                return LIST;
            } else {
                request.setAttribute("message", "Incorrect UserID or Password");
                return LOGIN_PAGE;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Incorrect UserID or Password");
            return LOGIN_PAGE;
        }
    }

    protected String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.invalidate();

        return LOGIN_PAGE;
    }

    protected void houseList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HouseDAO hd = new HouseDAO();
            List<HouseDTO> list = hd.list();

            if (!list.isEmpty()) {
                request.setAttribute("list", list);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected String search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String keyword = request.getParameter("keyword").trim();

            HouseDAO hd = new HouseDAO();
            List<HouseDTO> list = hd.search(keyword);

            if (!list.isEmpty()) {
                request.setAttribute("list", list);

            }
            return LIST;

        } catch (Exception ex) {
            ex.printStackTrace();
            return LOGIN_PAGE;
        }

    }

    protected String delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String id = request.getParameter("id").trim();
            String keyword = request.getParameter("keyword").trim();

            HouseDAO hd = new HouseDAO();
            hd.delete(id);

            List<HouseDTO> list = hd.search(keyword);

            if (!list.isEmpty()) {
                request.setAttribute("list", list);

            }
            return LIST;

        } catch (Exception ex) {
            ex.printStackTrace();
            return LOGIN_PAGE;
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
