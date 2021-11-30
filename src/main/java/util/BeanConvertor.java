package util;

import domain.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanConvertor {

    public List<Employee> getEmployeeList(ResultSet resultSet) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        if(resultSet!=null){
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setSalary(resultSet.getInt("salary"));
                employeeList.add(employee);
            }
        }

        return employeeList;
    }
    public Employee getEmployee(ResultSet resultSet) throws SQLException {
        if(resultSet!=null){
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setSalary(resultSet.getInt("salary"));
                return employee;
            }
        }

        return null;

    }


}
