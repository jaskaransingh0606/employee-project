package org.codingwala.employeeproject;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmpService {

    String createEmployee(Employee employee);       // Create a new employee
    List<Employee> readEmployees();                // Get all employees
    boolean deleteEmployee(Long id);           // Delete an employee
     
}

