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
import java.util.List;

@WebServlet("/findById")
public class findByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdminServiceImpl adminService = new AdminServiceImpl();
            String id = request.getParameter("id");
            Employee employee = adminService.findById(Integer.parseInt(id));

            request.setAttribute("employee",employee);

            request.getRequestDispatcher("/alter.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
