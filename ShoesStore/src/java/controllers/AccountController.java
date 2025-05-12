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
        String action = request.getAttribute("action").toString();

        switch (action) {
            case "login":
                login(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "register":
                register(request, response);
                break;
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            AccountFacade af = new AccountFacade();
            Account account = af.login(email, password);

            if (account != null) {
                // Nếu đăng nhập đúng, lưu account vào session và chuyển hướng về trang chủ
                HttpSession session = request.getSession();
                request.setAttribute("message", "Login successfully!!!");
                session.setAttribute("account", account);
                request.getRequestDispatcher("/").forward(request, response);
            } else {
                // Nếu đăng nhập sai, set thông báo lỗi và forward
                request.setAttribute("message", "Wrong email or password!!!");
                request.setAttribute("openRegisterModal", true);
                request.getRequestDispatcher("/").forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("openRegisterModal", true);
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lay tham chieu cua doi tuong session
        HttpSession session = request.getSession();

        // Huy session
        session.invalidate();

        // Cho hien home page
        request.getRequestDispatcher("/").forward(request, response);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");

            AccountFacade af = new AccountFacade();
            boolean success = af.register(email, password, fullName);
            if (success) {
                Account account = af.login(email, password);
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                request.setAttribute("message", "Register successfully!!!");
                request.getRequestDispatcher("/").forward(request, response);
            } else {

                request.setAttribute("message", "Email already exists! Please use another email.");
                // Đặt cờ để mở modal đăng ký trong trang chủ
                request.setAttribute("openRegisterModal", true);
                request.getRequestDispatcher("/").forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "An error occurred: " + ex.getMessage());
            request.setAttribute("openRegisterModal", true);
            request.getRequestDispatcher("/").forward(request, response);
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
