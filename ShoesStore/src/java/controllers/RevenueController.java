package controllers;

import db.Revenue;
import db.RevenueFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RevenueController", urlPatterns = {"/revenue"})
public class RevenueController extends HttpServlet {

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
            case "get":
                get(request, response);
                break;
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String type = request.getParameter("type").trim();

            RevenueFacade rf = new RevenueFacade();

            Revenue rev = new Revenue();
            List<Revenue> list = new ArrayList<>();

            String[] arr;
            int year, month, day;

            switch (type) {
                case "date":
                    arr = request.getParameter("date").trim().split("-");
                    year = Integer.parseInt(arr[0]);
                    month = Integer.parseInt(arr[1]);
                    day = Integer.parseInt(arr[2]);
                    rev = rf.getByDay(day, month, year);
                    break;
                case "month":
                    arr = request.getParameter("month").trim().split("-");
                    year = Integer.parseInt(arr[0]);
                    month = Integer.parseInt(arr[1]);
                    rev = rf.getByMonth(month, year);
                    break;
                case "year":
                    arr = request.getParameter("year").trim().split("-");
                    year = Integer.parseInt(arr[0]);
                    rev = rf.getByYear(year);
                    break;
                case "7days":
                    arr = request.getParameter("date").trim().split("-");
                    year = Integer.parseInt(arr[0]);
                    month = Integer.parseInt(arr[1]);
                    day = Integer.parseInt(arr[2]);
                    list = rf.getPrevious7Day(day, month, year);
                    break;
            }

            if (rev != null) {
                request.setAttribute("rev", rev);
            }

            if (list != null) {
                request.setAttribute("revList", list);
            }

            request.setAttribute("action", "index");
            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("message", "Error getting revenue");
            ex.printStackTrace();
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
