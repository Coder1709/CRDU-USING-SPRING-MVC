# Employee Management API

This API provides endpoints to manage employee records.

## Endpoints:

1. **Insert Dummy Employee**
    - **Method:** GET
    - **Path:** /rest/emp/dummy
    - **Description:** Inserts a dummy employee record into the database.
    - **Access:** Send a GET request to the specified path.
    - **Input:** No input required.
    - **Output:** Message indicating successful insertion of dummy data.

2. **Get Employee by ID**
    - **Method:** GET
    - **Path:** /rest/emp/{id}
    - **Description:** Retrieves an employee record by ID.
    - **Access:** Send a GET request to the specified path, replacing `{id}` with the ID of the employee.
    - **Input:** Employee ID in the URL path.
    - **Output:** JSON representation of the employee record.

3. **Get All Employees**
    - **Method:** GET
    - **Path:** /rest/emp/all
    - **Description:** Retrieves all employee records.
    - **Access:** Send a GET request to the specified path.
    - **Input:** No input required.
    - **Output:** List of JSON representations of all employee records.

4. **Create Employee**
    - **Method:** POST
    - **Path:** /rest/emp/create
    - **Description:** Creates a new employee record.
    - **Access:** Send a POST request to the specified path with the JSON representation of the employee in the request body.
    - **Input:** JSON representation of the new employee.
    - **Output:** Message indicating successful creation of the employee.

5. **Delete Employee by ID**
    - **Method:** DELETE
    - **Path:** /rest/emp/delete/{id}
    - **Description:** Deletes an employee record by ID.
    - **Access:** Send a DELETE request to the specified path, replacing `{id}` with the ID of the employee to delete.
    - **Input:** Employee ID in the URL path.
    - **Output:** Message indicating successful deletion of the employee.

6. **Get Employee JSON by ID**
    - **Method:** GET
    - **Path:** /rest/emp/getEmp/{id}
    - **Description:** Retrieves employee data in JSON format by ID.
    - **Access:** Send a GET request to the specified path, replacing `{id}` with the ID of the employee.
    - **Input:** Employee ID in the URL path.
    - **Output:** JSON representation of the employee data.

7. **Edit Employee**
    - **Method:** PUT
    - **Path:** /rest/emp/edit
    - **Description:** Updates an existing employee record.
    - **Access:** Send a PUT request to the specified path with the JSON representation of the updated employee in the request body.
    - **Input:** JSON representation of the updated employee.
    - **Output:** Message indicating successful update of the employee.

## Request and Response Examples:

- **Create Employee Request Example:**
```json
{
  "name": "John Doe",
  "educationalQualification": "Bachelor's in Computer Science",
  "dateOfJoining": "2022-04-28",
  "email": "john.doe@example.com",
  "contactNumber": "+1234567890",
  "designation": "Software Engineer"
}


- **Create Employee Response Example:**
```json

{
  "id": 1,
  "name": "John Doe",
  "educationalQualification": "Bachelor's in Computer Science",
  "dateOfJoining": "2022-04-28",
  "email": "john.doe@example.com",
  "contactNumber": "+1234567890",
  "designation": "Software Engineer"
}
# CRDU-USING-SPRING-MVC
