package pe.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.account.AccountDAO;
import pe.account.AccountDTO;
import pe.employee.EmployeeDAO;
import pe.employee.EmployeeDTO;


public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            System.out.println("action: " + action);
            switch (action) {
                case "login":
                    url = login(request, response);
                    break;
                case "logout":
                    url = logout(request, response);
                    break;
                case "create":
                    url = create(request, response);
                    break;
                case "create_handler":
                    url = create_handler(request, response);
                    break;
                case "search":
                    url = searchEmployee(request, response);
                    break;
                case "remove":
                    url = remove(request,response);
            }
            
            
        } catch (Exception e) {
            request.setAttribute("message", e.toString());
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    protected String login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "login.jsp";
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "login":
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    AccountDAO af = new AccountDAO();
                    AccountDTO account = af.login(email, password);

                    if (account != null) {

                        HttpSession session = request.getSession();

                        session.setAttribute("account", account);

                        url = "employees.jsp";

                        employeeList(request, response);
                    } else {
                        throw new Exception("Incorrect email or password");
                    }
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Incorrect email or password");
        }
        return url;
    }

    protected void employeeList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmployeeDAO ef = new EmployeeDAO();
            List<EmployeeDTO> list = ef.select();

            HttpSession session = request.getSession();
            session.setAttribute("list", list);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", "Error reading employees table");
        }
    }

    protected String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.invalidate();

        return "login.jsp";
    }
    protected String create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = "login.jsp";
      

        AccountDTO acc = (AccountDTO) session.getAttribute("account");

        if (acc.getRoleId().equals("AM")) {
            url = "create.jsp";
        }
        return url;
    }
    protected String create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "create.jsp";

        try {
            String op = request.getParameter("op");
            switch (op) {
                case "create":
                    
                    String fullName = request.getParameter("fullName");
                    String sdob = request.getParameter("dob");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dob = sdf.parse(sdob);
                    double salary = Double.parseDouble(request.getParameter("salary"));
                    
           
                   String errorMes = null;
                   if( fullName != null){
                       if(fullName.length() < 3  || fullName.length() > 50){
                           errorMes = "The full name length must be between 3 and 50 characters";
                       }
                   }
                   else{
                       errorMes = "The full name can not be blank";
                   }
                   
                   if (dob == null || sdob == null) {
                        errorMes = "Date of Birth cannot be left blank";
                    }

                    
                    if (salary < 100.0 || salary > 10000.0) {
                        errorMes = "The salary field must be between 100 and 10000 and can have one digit in the decimal part";
                    } 
                    
                    if (errorMes != null) {
                        request.setAttribute("message", errorMes);
                        url = "create.jsp";
                        break;
                    }
                    
                    
                    //insert data vao db
                    EmployeeDAO tf = new EmployeeDAO();
                    tf.create(fullName, dob, salary); 
                    
                    url = "employees.jsp";
                    break;
                case "cancel":
                    url = "employees.jsp";
                    break;
            }
            
        } catch (ParseException ex) {  
            ex.printStackTrace();
            request.setAttribute("message", "Date of Birth cannot be left blank");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex);
        }
        employeeList(request, response);
        return url;
    }
    protected String searchEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String url = "employees.jsp";
        String searchValue = request.getParameter("searchValue");
        
        EmployeeDAO employee = new EmployeeDAO();
        request.setAttribute("employeeList", employee.searchEmployee(searchValue));
        request.setAttribute("searchValue", searchValue);
        
        return url;
    }
        protected String remove(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String url = "employees.jsp";
    try {
        String id = request.getParameter("id");
        EmployeeDAO ed = new EmployeeDAO();
        ed.remove(id); // Xóa nhân viên

        // Lấy danh sách nhân viên mới từ DB sau khi xóa
        List<EmployeeDTO> updatedList = ed.getAllEmployees();

        // Cập nhật danh sách vào request
        request.setAttribute("list", updatedList);
        
    } catch (Exception ex) {
        ex.printStackTrace();
        request.setAttribute("message", "Can't remove");
        url = "employees.jsp";
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
