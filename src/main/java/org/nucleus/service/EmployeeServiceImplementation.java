package org.nucleus.service;

import org.nucleus.dao.EmployeeDaoImplementation;
import org.nucleus.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeDaoImplementation employeeDaoImplementation;


    @Override
    public void insertEmployeeService() {
        System.out.println("Service Layer Got Called");
        employeeDaoImplementation.insertDummyEmployee();

    }

    @Override
    public Employee getEmployeeByIdService(int id) {
        return employeeDaoImplementation.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployeesService() {
        return employeeDaoImplementation.getAllEmployees();
    }

    @Override
    public void createEmployeeService(Employee employee) {
        employeeDaoImplementation.createEmployee(employee);

    }

    @Override
    public void deleteEmployeeByIdService(int id) {
        employeeDaoImplementation.deleteEmployeeById(id);

    }

    @Override
    public String getEmployeeJsonByIdService(int id) {
        return employeeDaoImplementation.getEmployeeJsonById(id);
    }

    @Override
    public void updateEmployeeService(Employee employee) {
        employeeDaoImplementation.updateEmployee(employee);
    }


    public EmployeeDaoImplementation getEmployeeDaoImplementation() {
        return employeeDaoImplementation;
    }

    public void setEmployeeDaoImplementation(EmployeeDaoImplementation employeeDaoImplementation) {
        this.employeeDaoImplementation = employeeDaoImplementation;
    }
}
