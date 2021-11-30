package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import domain.Employee;
import service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    public AdminServiceImpl() throws SQLException {


    }

    @Override
    public Employee adminLogin(String username, String password) throws SQLException {
        //only ceo and hr can login and admin...
        Employee employee = adminDao.employeeLogin(username, password);
        if(employee.getDepartment().equals("ceo")||employee.getDepartment().equals("hr")){
            return employee;
        }else{
            return null;
        }

    }

    @Override
    public List<Employee> findAllEmployee() throws SQLException {
        List<Employee> employeeList = adminDao.findAllEmployee();
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        employee.setPassword("123456");
        adminDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        adminDao.deleteEmployee(id);
    }

    @Override
    public void alterEmployee(Employee employee) throws SQLException {
        adminDao.alterEmployee(employee);
    }

    @Override
    public Employee findById(int id) throws SQLException {
        return adminDao.findById(id);
    }
}
