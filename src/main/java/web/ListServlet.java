package web;

import domain.Employee;
import service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdminServiceImpl adminService = new AdminServiceImpl();
            List<Employee> employeeList = adminService.findAllEmployee();
            request.setAttribute("employeeList",employeeList);

            request.getRequestDispatcher("/employeeList.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
