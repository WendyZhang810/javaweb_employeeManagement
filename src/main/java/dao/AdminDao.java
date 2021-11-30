package dao;

import domain.Employee;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

    List<Employee> findAllEmployee() throws SQLException;

    void deleteEmployee(int id) throws SQLException;

    void alterEmployee(Employee employee) throws SQLException;

    void addEmployee(Employee employee) throws SQLException;

    Employee employeeLogin(String name, String password) throws SQLException;

    Employee findById(int id) throws SQLException;
}
