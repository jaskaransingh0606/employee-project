package org.codingwala.employeeproject;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// import org.springframework.web.bind.annotation.RequestParam;
// import java.util.ArrayList;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class EmpController {
    // List<Employee> employees = new ArrayList<Employee>();
    // EmpServicesImp empService = new EmpServicesImp();


    //Dependency Injection , it will inject the EmpServiceImp object without creating a new object using IOC container

    @Autowired
    EmpService empService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        
        return empService.readEmployees();
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        // employees.add(employee);
        

        empService.createEmployee(employee);
        
        return "saved successfully";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
       if(empService.deleteEmployee(id)){
              return "deleted successfully";
       } else{
              return "Employee not found";
       }
    }
    
    
    
}
