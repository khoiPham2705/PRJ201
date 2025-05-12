/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.product.ProductDAO;
import pe.product.ProductDTO;
import pe.user.UserDAO;
import pe.user.UserDTO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String LOGIN_PAGE = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOGIN_PAGE;
            }
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
                case "remove":
                    url = remove(request, response);
                    break;

            }
//            your code here

        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    protected String login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String url = "login.jsp";
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "login":
                    String userId = request.getParameter("userId");
                    String password = request.getParameter("password");

                    UserDAO ud = new UserDAO();
                    UserDTO user = ud.login(userId, password);

                    if (user != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        url = "product.jsp";

                    } else {
                        throw new Exception("Incorrect userId or password1");
                    }
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Incorrect userId or password2");
        }
        return url;

    }

    protected String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.invalidate();

        return "login.jsp";
    }

    protected String search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String url = "product.jsp";
        String searchValue = request.getParameter("searchValue");

        ProductDAO productDao = new ProductDAO();
        request.setAttribute("productList", productDao.searchProduct(searchValue));
        request.setAttribute("searchValue", searchValue);

        return url;
    }

    protected String remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "product.jsp";
        try {
            String id = request.getParameter("id");
            ProductDAO ed = new ProductDAO();
            ed.remove(id); // Xóa nhân viên

            // Lấy danh sách nhân viên mới từ DB sau khi xóa
            List<ProductDTO> updatedList = ed.getAllEmployees();

            // Cập nhật danh sách vào request
            request.setAttribute("list", updatedList);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't remove");
            url = "product.jsp";
        }
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
