package org.nucleus.service;

import org.nucleus.model.Employee;

import java.util.List;

public interface EmployeeService {
    // Insert a dummy employee record
    void insertEmployeeService();

    // Get employee by ID
    Employee getEmployeeByIdService(int id);

    // Get list of all employees
    List<Employee> getAllEmployeesService();

    // Create a new employee
    void createEmployeeService(Employee employee);

    // Delete employee by ID
    void deleteEmployeeByIdService(int id);

    // Get employee data in JSON format by ID
    String getEmployeeJsonByIdService(int id);

    // Update employee details
    void updateEmployeeService(Employee employee);
}
