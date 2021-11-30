package dao.impl;

import dao.AdminDao;
import domain.Employee;
import util.BeanConvertor;
import util.C3P0Utils;

import java.sql.*;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    Connection connection =C3P0Utils.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet= null;

    public AdminDaoImpl() throws SQLException {
    }

    @Override
    public List<Employee> findAllEmployee() throws SQLException {
        String sql = "select * from employee";
        preparedStatement=connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        //convert resultset into list, using util...
        BeanConvertor beanConvertor = new BeanConvertor();
        List<Employee> employeeList = beanConvertor.getEmployeeList(resultSet);

        C3P0Utils.close(connection, preparedStatement, resultSet);
        return employeeList;
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        C3P0Utils.close(connection, preparedStatement, resultSet);

    }

    @Override
    public void alterEmployee(Employee employee) throws SQLException {
        String sql = "update employee set name=?,department=?, salary=? where id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getDepartment());
        preparedStatement.setInt(3,employee.getSalary());
        preparedStatement.setInt(4,employee.getId());
        preparedStatement.executeUpdate();
        C3P0Utils.close(connection, preparedStatement, resultSet);
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee values(null, ?,?,?,?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getPassword());
        preparedStatement.setString(3,employee.getDepartment());
        preparedStatement.setInt(4,employee.getSalary());
        preparedStatement.executeUpdate();
        C3P0Utils.close(connection, preparedStatement, resultSet);
    }

    @Override
    public Employee employeeLogin(String name, String password) throws SQLException {
        String sql = "select * from employee where name =? and password=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        resultSet=preparedStatement.executeQuery();

        BeanConvertor beanConvertor = new BeanConvertor();
        Employee employee = beanConvertor.getEmployee(resultSet);
        C3P0Utils.close(connection, preparedStatement, resultSet);

        return employee;

    }

    @Override
    public Employee findById(int id) throws SQLException {
        String sql = "select * from employee where id=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        resultSet=preparedStatement.executeQuery();

        BeanConvertor beanConvertor = new BeanConvertor();
        Employee employee = beanConvertor.getEmployee(resultSet);

        C3P0Utils.close(connection, preparedStatement, resultSet);
        return employee;
    }


}
