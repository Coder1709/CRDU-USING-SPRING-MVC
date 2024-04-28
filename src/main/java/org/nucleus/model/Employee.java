package org.nucleus.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;
import java.time.LocalDate;

@EnableWebMvc
@ValidateOnExecution
public class Employee {


    private int id;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Employee name must contain only alphabets")
    private String name;

    private String educationalQualification;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoining;

    @NotEmpty(message = "Email must not be empty")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    private String email;

    @NotEmpty
    @Size(min = 10, max = 10, message = "Contact number must be 10 digits long")
    private String contactNumber;

    private String designation;


    public Employee() {
        super();
    }

    public Employee(int id ,String name, String educationalQualification, LocalDate dateOfJoining, String email, String contactNumber, String designation) {
        this.id =id;
        this.name = name;
        this.educationalQualification = educationalQualification;
        this.dateOfJoining = dateOfJoining;
        this.email = email;
        this.contactNumber = contactNumber;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducationalQualification() {
        return educationalQualification;
    }

    public void setEducationalQualification(String educationalQualification) {
        this.educationalQualification = educationalQualification;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + name + '\'' +
                ", educationalQualification='" + educationalQualification + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
