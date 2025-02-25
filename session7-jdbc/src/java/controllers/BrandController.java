package controllers;

import db.Brand;
import db.BrandFacade;
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

@WebServlet(name="BrandController", urlPatterns={"/brand"})
public class BrandController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            case "index":
                index(request, response);
                break;
            case "create":
                // Hien form
                create(request, response);
                break;
            case "create_handler":
                // Xu ly form
                create_handler(request, response);
                break;
            case "delete":
                // Hien form
                delete(request, response);
                break;
            case "delete_handler":
                // Xu ly form
                delete_handler(request, response);
                break;
            case "edit":
                // Hien form
                edit(request, response);
                break;
            case "edit_handler":
                // Xu ly form
                edit_handler(request, response);
                break;
        }
    }
    
    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //doc table brand
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
            //luu list vao request
            request.setAttribute("list", list);
            //forward request va response cho view 
            request.getRequestDispatcher(config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(config.LAYOUT).forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    // Tao doi tuong "brand"
                    Brand brand = new Brand(id, name);
                    // insert data vao db
                    BrandFacade bf = new BrandFacade();
                    bf.create(brand);
                case "cancel":
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/brand/index.do").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't add new brand");
            request.getRequestDispatcher("/create-brand.jsp").forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(config.LAYOUT).forward(request, response);
    }

    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "yes":
                    String id = request.getParameter("id");
                    BrandFacade bf = new BrandFacade();
                    bf.delete(id);
                case "no":
                    // Cho hien danh sach brand, chay lai case index
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/brand/index.do").forward(request, response);
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
            BrandFacade bf = new BrandFacade();
            Brand brand = bf.read(id);
            request.setAttribute("brand", brand);
            request.getRequestDispatcher(config.LAYOUT).forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void edit_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "update":
                    // Lay thong tin tu client
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    // Tao doi tuong "brand"
                    Brand brand = new Brand(id, name);
                    // update
                    BrandFacade bf = new BrandFacade();
                    bf.update(brand);
                case "cancel":
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/brand/index.do").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't edit brand");
            request.getRequestDispatcher("/brand/edit.do").forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}