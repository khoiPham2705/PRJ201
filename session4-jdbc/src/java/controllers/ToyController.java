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
 * @author LAPTOP
 */
@WebServlet(name = "ToyController", urlPatterns = {"/toy/*"})
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
        String uri = request.getRequestURI();
        //String url = request.getRequestURL().toString();
        //System.out.println("uri: " + uri);
        //System.out.println("url: " + url);
        int m = uri.lastIndexOf("/");
        int n = uri.indexOf(".");
        String action = uri.substring(m+1,n);
        //System.out.println(action);
        
        switch (action) {
            case "index":
                index(request, response);
                break;
            case "create":
                // Hien create form
                create(request, response);
                break;
            case "create_handler":
                // Xu ly create form
                create_handler(request, response);
                break;
            case "delete":
                // Hien delete form
                delete(request, response);
                break;
            case "delete_handler":
                // Xu ly delete form
                delete_handler(request, response);
                break;  
            case "edit":
                // Hien edit form
                edit(request, response);
                break;
            case "edit_handler":
                // Xu ly edit form
                edit_handler(request, response);
                break;  
    }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //doc table toy
            ToyFacade tf = new ToyFacade();
            List<Toy> list = tf.select();
            //luu list vao request
            request.setAttribute("list", list);
            //forward request va response cho view 
            request.getRequestDispatcher("/toy.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Read table brand
        BrandFacade bf = new BrandFacade();
        List<Brand> list = bf.select();
        
        // Sent list to view to create combo box
        request.setAttribute("list", list);
        // Show view
        request.getRequestDispatcher("/create.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    // Lấy thông tin từ client
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    double price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    String brand = request.getParameter("brand");
                    // Tạo đối tượng Toy
                    Toy toy = new Toy();
                    toy.setId(id);
                    toy.setName(name);
                    toy.setPrice(price);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    toy.setExpDate(sdf.parse(expDate));
                    toy.setBrand(brand);
                    // insert data vào db
                    ToyFacade tf = new ToyFacade();
                    tf.create(toy);
                case "cancel":
//                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    request.getRequestDispatcher("/toy/index.do").forward(request, response);
                    break;
            }

            request.getRequestDispatcher("/toy/create.do").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't insert a new toy");
            // Cho hiện lại create form
            request.getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            request.getRequestDispatcher("/delete.jsp").forward(request, response);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    protected void delete_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "yes":
                       String id = request.getParameter("id");
                       //xoa toy
                       ToyFacade tf = new ToyFacade();
                       tf.delete(id);
                case "no":
                    //cho hien danh sach toys ( chay lai case index )
                    request.getRequestDispatcher("/toy/index.do").forward(request, response);
                    break;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message","Can't insert a new toy");
            request.getRequestDispatcher("/delete.jsp").forward(request,response);
        }
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            // doc toy tu db
            ToyFacade tf = new ToyFacade();
            Toy toy = tf.read(id);
            // luu toy vao request de truyen vao view
            request.setAttribute("toy",toy);
            
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();
        
            // Sent list to view to create combo box
            request.setAttribute("list", list);
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
                    double price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    String brand = request.getParameter("brand");
                    //tao doi tuong toy
                    Toy toy = new Toy();
                    toy.setId(id);
                    toy.setName(name);
                    toy.setPrice(price);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    toy.setExpDate(sdf.parse(expDate));
                    toy.setBrand(brand);
                    
                    //insert data vao db
                    ToyFacade tf = new ToyFacade();
                    tf.update(toy);     
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
