package service;

import domain.Employee;

import java.sql.SQLException;
import java.util.List;

public interface AdminService {

    Employee adminLogin(String username, String password) throws SQLException;

    List<Employee> findAllEmployee() throws SQLException;

    void addEmployee(Employee employee) throws SQLException;

    void deleteEmployee(int id) throws SQLException;

    void alterEmployee(Employee employee) throws SQLException;

    Employee findById(int id) throws SQLException;
}
