package org.nucleus.dao;

import org.nucleus.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface EmployeeDAO {




    // Insert a dummy employee record
    void insertDummyEmployee();

    // Get employee by ID
    Employee getEmployeeById(int id);

    // Get list of all employees
    List<Employee> getAllEmployees();

    // Create a new employee
    void createEmployee(Employee employee);

    // Delete employee by ID
    void deleteEmployeeById(int id);

    // Get employee data in JSON format by ID
    String getEmployeeJsonById(int id);

    // Update employee details
    void updateEmployee(Employee employee);
}
