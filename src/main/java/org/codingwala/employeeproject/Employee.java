package org.codingwala.employeeproject;

import lombok.Data;

@Data // Lombok annotation to create all the getters, setters, equals, hashcode, and
      // toString methods, based on the fields
public class Employee {
    private Long id;
    private String name;
    private String phone;
    private String email;

}
