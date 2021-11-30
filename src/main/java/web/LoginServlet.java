package web;

import domain.Employee;
import service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            AdminServiceImpl adminService = new AdminServiceImpl();
            Employee employee = adminService.adminLogin(username, password);

            if(employee!=null){
                Cookie cookie = new Cookie("username", employee.getName());
                Cookie cookie_isLogin = new Cookie("isLogin", "true");
                response.addCookie(cookie);
                response.addCookie(cookie_isLogin);

                request.getRequestDispatcher("/list").forward(request,response);
            }else{
                request.setAttribute("msg","wrong username or password!");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
