package controllers;

import cart.Cart;
import db.Account;
import db.Shoes;
import db.ShoesFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

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
            case "add":
                add(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            case "empty":
                empty(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "checkout":
                checkout(request, response);
                break;
        }
    }

    protected void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String size = request.getParameter("shoe_size");
            ShoesFacade pf = new ShoesFacade();
            Shoes shoes = pf.select(id);

            // Lay cart tu session
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            // Them product vao cart
            cart.add(shoes, 1, size);

            // Cho hien view index
            request.getRequestDispatcher("/").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
    }

    protected void empty(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.empty();
        request.getRequestDispatcher("/").forward(request, response);
    }

    protected void remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int id = Integer.parseInt(request.getParameter("id"));
        String size = request.getParameter("shoe_size");
        cart.remove(id, size);

        request.getRequestDispatcher("/cart/index.do").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String size = request.getParameter("size");
        // Cap nhat cart
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        cart.update(id, size, quantity);

        request.getRequestDispatcher("/cart/index.do").forward(request, response);
    }

    protected void checkout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            Account account = (Account) session.getAttribute("account");
            //Neu customer chua login thi bat buoc phai login truoc khi checkout
            if (account == null) {
                //Lưu url hiện tại để quay trở lại sau khi login
                //session.setAttribute("oldUrl", "/cart/checkout.do");
                //Chuyen ve trang /cart/index.do va hien hop thoai login
//                response.sendRedirect(request.getContextPath() + "/cart/index.do?login=1");
            } else {
                String address = request.getParameter("address").trim();
                String phone = request.getParameter("phone").trim();

                if (!cart.isEmpty()) {
                    // Proceed with checkout
                    cart.checkout(account.getId(), address, phone);
                    cart.empty();
                } else {
                    request.getRequestDispatcher("/").forward(request, response);
                    return;
                }

                // Forward
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();//in chi tiết ngoại lệ
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
