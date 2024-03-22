package org.codingwala.employeeproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class EmpServicesImp implements EmpService {

    List<Employee> employees = new ArrayList<Employee>();
    
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        employees.add(employee);
        return "saved Succesfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<Employee>();
        for (EmployeeEntity employeeEntity : employeesList) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity, employee);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
    Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            return true;
        }
        return false;
       
    }

}
