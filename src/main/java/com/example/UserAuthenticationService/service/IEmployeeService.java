package com.example.UserAuthenticationService.service;

import com.example.UserAuthenticationService.domain.Employee;
import com.example.UserAuthenticationService.exception.EmployeeExistAlready;
import com.example.UserAuthenticationService.exception.EmployeeNotFound;

import  java.util.*;

public interface IEmployeeService {
    Employee saveEmploy(Employee e) throws EmployeeExistAlready;
    List<Employee> getEmployees();
    Employee getEmployeeByEmailAndPassword(String email, String password) throws EmployeeNotFound;


}
