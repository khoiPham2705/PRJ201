
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
            //doc table toy
            ToyFacade tf = new ToyFacade();
            List<Toy> list = tf.select();
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
        try {
            // Read table brand
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();

            // Sent list to view to create combo box
            request.setAttribute("list", list);
            // Show view
            request.getRequestDispatcher(config.LAYOUT).forward(request, response);
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
                    String id = request.getParameter("id");
                    String name = request.getParameter("name");
                    double price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    String brand = request.getParameter("brand");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    // Tao doi tuong "toy"
                    Toy toy = new Toy(id, name, price, sdf.parse(expDate), brand);
                    // insert data vao db
                    ToyFacade tf = new ToyFacade();
                    tf.create(toy);
                case "cancel":
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/toy/index.do").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't add new toy");
            request.getRequestDispatcher("/toy/create.do").forward(request, response);
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
                    ToyFacade tf = new ToyFacade();
                    tf.delete(id);
                case "no":
                    // Cho hien danh sach toy, chay lai case index
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
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
            ToyFacade tf = new ToyFacade();
            Toy toy = tf.read(id);
            request.setAttribute("toy", toy);
            
            // Read table brand
            BrandFacade bf = new BrandFacade();
            List<Brand> list = bf.select();

            // Sent list to view to create combo box
            request.setAttribute("list", list);
            
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
                    double price = Double.parseDouble(request.getParameter("price"));
                    String expDate = request.getParameter("expDate");
                    String brand = request.getParameter("brand");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    // Tao doi tuong "toy"
                    Toy toy = new Toy(id, name, price, sdf.parse(expDate), brand);
                    // update
                    ToyFacade tf = new ToyFacade();
                    tf.update(toy);
                case "cancel":
                    // Cach 1
                    //request.getRequestDispatcher("/index.jsp").forward(request, response);

                    // Cach 2
                    request.getRequestDispatcher("/toy/index.do").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Can't edit toy");
            // edit(request, response);
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
