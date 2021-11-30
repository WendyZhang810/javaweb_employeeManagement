package web;

import domain.Employee;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdminServiceImpl adminService = new AdminServiceImpl();
            Employee employee = new Employee();

            employee.setName(request.getParameter("name"));
            employee.setDepartment(request.getParameter("department"));
            employee.setSalary(Integer.parseInt(request.getParameter("salary")));

            adminService.addEmployee(employee);

            request.getRequestDispatcher("/list").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
