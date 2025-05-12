package controllers;

import db.Paint;
import db.PaintFacade;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PaintController", urlPatterns = {"/paint"})
public class PaintController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getAttribute("action").toString();

        switch (action) {
            case "index":
                index(request, response);
                break;
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int pageSize = 6;
            String spage = request.getParameter("page");
            int page = (spage == null) ? 1 : (Integer.parseInt(spage) <= 0) ? 1 : Integer.parseInt(spage);

            PaintFacade pf = new PaintFacade();
            List<Paint> list = pf.select(page, pageSize);

            request.setAttribute("page", page);
            int totalPage = (int) Math.ceil((double) pf.count() / pageSize);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("list", list);

            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "PaintController";
    }
}
