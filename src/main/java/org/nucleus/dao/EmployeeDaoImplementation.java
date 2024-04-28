package org.nucleus.dao;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nucleus.model.Employee;
import org.nucleus.utils.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeDaoImplementation implements EmployeeDAO{



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertDummyEmployee() {
        try {
            System.out.println("Dao Layer Got Called");
            // Creating an instance of Employee
            Employee employee = new Employee();

            // Setting values for the fields
            employee.setName("John Doe");
            employee.setEducationalQualification("Bachelor's in Computer Science");
            employee.setDateOfJoining(LocalDate.of(2022, 4, 28));
            employee.setEmail("john.doe@example.com");
            employee.setContactNumber("+1234567890");
            employee.setDesignation("Software Engineer");

            String sql = "INSERT INTO Employee (name, educational_qualification, date_of_joining, email, contact_number, designation) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, employee.getName(), employee.getEducationalQualification(), employee.getDateOfJoining(), employee.getEmail(), employee.getContactNumber(), employee.getDesignation());

            System.out.println("Employee inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error inserting employee: " + e.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        try {
            // Execute the query and map the result to an Employee object
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // Handle the case when no employee is found with the given ID
            System.err.println("No employee found with ID: " + id);
            return null;
        } catch (DataAccessException e) {
            // Handle any other database access error
            System.err.println("Error retrieving employee: " + e.getMessage());
            return null;
        }
    }


    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM Employee";
        try {
            // Execute the query and map the result to a list of Employee objects
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        } catch (DataAccessException e) {
            // Handle any database access error
            System.err.println("Error retrieving all employees: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void createEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (name, educational_qualification, date_of_joining, email, contact_number, designation) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, employee.getName(), employee.getEducationalQualification(),
                    employee.getDateOfJoining(), employee.getEmail(), employee.getContactNumber(), employee.getDesignation());
        } catch (DataAccessException e) {
            // Handle any database access error
            System.err.println("Error creating employee: " + e.getMessage());
        }
    }
    @Override
    public void deleteEmployeeById(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            // Handle any database access error
            System.err.println("Error deleting employee with ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public String getEmployeeJsonById(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        try {
            Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
            if (employee != null) {
                // Convert the Employee object to JSON format and return
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(employee);
            }
        } catch (DataAccessException | JsonProcessingException e) {
            // Handle any database access error or JSON processing error
            System.err.println("Error retrieving employee JSON for ID " + id + ": " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employee SET name = ?, educational_qualification = ?, date_of_joining = ?, email = ?, contact_number = ?, designation = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, employee.getName(), employee.getEducationalQualification(),
                    employee.getDateOfJoining(), employee.getEmail(), employee.getContactNumber(),
                    employee.getDesignation(), employee.getId());
        } catch (DataAccessException e) {
            // Handle any database access error
            System.err.println("Error updating employee: " + e.getMessage());
        }
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
