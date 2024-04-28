package org.nucleus.utils;

import org.springframework.jdbc.core.RowMapper;
import org.nucleus.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setName(rs.getString("name"));
        employee.setEducationalQualification(rs.getString("educational_qualification"));
        employee.setDateOfJoining(rs.getDate("date_of_joining").toLocalDate());
        employee.setEmail(rs.getString("email"));
        employee.setContactNumber(rs.getString("contact_number"));
        employee.setDesignation(rs.getString("designation"));
        return employee;
    }
}

