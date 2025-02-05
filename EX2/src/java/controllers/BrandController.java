/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author LAPTOP
 */
@WebServlet(urlPatterns = {"/brand"})
public class BrandController extends HttpServlet {

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
                create(request, response);
                break;
            case "create_handler":
                // Xu ly create form
                create_handler(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "delete_handler":
                delete_handler(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "edit_handler":
                edit_handler(request, response);
                break;
                

        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //doc table toy
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
            //luu list vao request
            request.setAttribute("list", list);
            //forward request va response cho view 
            request.getRequestDispatcher("/brand.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");

                    //tao doi tuong brand
                    Brand brand = new Brand();
                    brand.setId(id);
                    brand.setName(name);

                    //insert data vao db
                    BrandFacade bf = new BrandFacade();
                    bf.create(brand);
                case "cancel":
                    request.getRequestDispatcher("/brand?action=index").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't insert a new toy");
            request.getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
     protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/delete.jsp").forward(request, response);
    }

    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "yes":
                    String id = request.getParameter("id");
                    //xoa toy
                    BrandFacade bf = new BrandFacade();
                    bf.delete(id);
                case "no":
                    request.getRequestDispatcher("/brand?action=index").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't insert a new toy");
            request.getRequestDispatcher("/delete.jsp").forward(request, response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            // doc toy tu db
            BrandFacade bf = new BrandFacade();
            Brand brand = bf.read(id);
            // luu toy vao request de truyen vao view
            request.setAttribute("brand",brand);
            //cho hien view edit.jsp
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    protected void edit_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "update":
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    
                    //tao doi tuong toy
                    Brand brand = new Brand();
                    brand.setId(id);
                    brand.setName(name);
                    
                    
                    //insert data vao db
                    BrandFacade bf = new BrandFacade();
                    bf.update(brand);     
                case "cancel":
                    //cho hien danh sach toys ( chay lai case index )
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message","Can't insert a new toy");
            edit(request, response);
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
