package test;

import dao.impl.AdminDaoImpl;
import domain.Employee;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class DaoTest {

    @Test   //test method findAllEmployee...
    public void test1() throws SQLException {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        List<Employee> employeeList = adminDao.findAllEmployee();

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Test  //add new employee...
    public void test2() throws SQLException {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Employee employee = new Employee();
        employee.setName("test_worker");
        employee.setPassword("123456");
        employee.setDepartment("intern");
        employee.setSalary(2000);

        adminDao.addEmployee(employee);
        test1();
    }

    @Test  //delete an employee...
    public void test3() throws SQLException {
        AdminDaoImpl adminDao = new AdminDaoImpl();

        adminDao.deleteEmployee(7);
        test1();
    }

    @Test  //alter an employee...
    public void test4() throws SQLException {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("william");
        employee.setDepartment("ceo");
        employee.setSalary(15000);

        adminDao.alterEmployee(employee);
        test1();
    }

    @Test  //login...
    public void test5() throws SQLException {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Employee mary = adminDao.employeeLogin("william", "123456");
        System.out.println(mary);
    }

    @Test //test find by id...
    public void test6() throws SQLException {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Employee employee = adminDao.findById(1);
        System.out.println(employee);
    }


}
