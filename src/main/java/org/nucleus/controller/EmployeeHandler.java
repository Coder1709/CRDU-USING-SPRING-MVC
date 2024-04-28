package org.nucleus.controller;



import org.nucleus.exception.UnAvailableException;
import org.nucleus.model.Employee;
import org.nucleus.service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class EmployeeHandler {

    @Autowired
    private EmployeeServiceImplementation employeeService;

    public EmployeeServiceImplementation getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeServiceImplementation employeeService) {
        this.employeeService = employeeService;
    }

    //Rest API Endpoint For Inserting some dummy data into the database\
    @GetMapping(path = "/rest/emp/dummy" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertDummyEmployee() {
        System.out.println("Dummy data Handler Got Called");
        employeeService.insertEmployeeService();
        return ResponseEntity.ok().body("Dummy Data Inserted Successfully");//This will return the string "Dummy Data Inserted Successfully" when the URL is hit
    }

    @GetMapping(path = "/rest/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployeeByIdService(id);
        if (employee == null) {
            throw new UnAvailableException("Employee with ID " + id + " not found");
        }
        return ResponseEntity.ok().body(employee);
    }
    //handling the exception for the above method
    @ExceptionHandler(UnAvailableException.class)
    public ResponseEntity<String> handleUnavailableException(UnAvailableException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @GetMapping(path = "/rest/emp/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        System.out.println("All Employees Handler Got Called");
        List<Employee> allEmployeesService = employeeService.getAllEmployeesService();
        return ResponseEntity.ok().body(allEmployeesService);
    }

    /*
    This method signature, public ResponseEntity<?> createEmployee(@RequestBody Employee employee),
    declares a method named createEmployee that accepts an Employee object as a parameter.
    The @RequestBody annotation instructs Spring to deserialize the incoming JSON request body into an Employee object.
    */

    @PostMapping(path="/rest/emp/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // If validation errors exist, return validation error messages
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        } else {
            // If no validation errors, proceed with creating the employee
            employeeService.createEmployeeService(employee);
            return ResponseEntity.ok().body("Employee Created Successfully");
        }
    }

    //this is the json format of the employee object that we will pass in the request body

        /*
        {
        "name": "Anand Pandey",
        "educationalQualification": "Bachelor's in Computer Science",
        "dateOfJoining": "2022-04-28",
        "email": "anand.doe@example.com",
        "contactNumber": "+1234567890",
        "designation": "Software Engineer"
        }
        */


    @DeleteMapping(path = "/rest/emp/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") int id) {
        employeeService.deleteEmployeeByIdService(id);
        return ResponseEntity.ok().body("Employee Deleted Successfully");
    }

    @GetMapping(path = "/rest/emp/getEmp/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getEmployeeByIdService(@PathVariable("id") int id) {
        String employeeJsonByIdService = employeeService.getEmployeeJsonByIdService(id);
        return ResponseEntity.ok().body(employeeJsonByIdService);
    }

    @PutMapping(path = "/rest/emp/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // If validation errors exist, return validation error messages
            return ResponseEntity.badRequest().body("Validation failed: " + bindingResult.getAllErrors());
        } else {
            // If no validation errors, proceed with editing the employee
            employeeService.updateEmployeeService(employee);
            return ResponseEntity.ok().body("Employee Edited Successfully");
        }
    }

    //You need to add id of the employee as id is getting generated by the database sequence

    /*{
    "id":"105",
    "name": "Anand Pandey",
    "educationalQualification": "Bachelor's in Computer Science",
    "dateOfJoining": "2022-04-28",
    "email": "Anand@gmail.com",
    "contactNumber": "9415317724",
    "designation": "Software Engineer"
}*/

}
