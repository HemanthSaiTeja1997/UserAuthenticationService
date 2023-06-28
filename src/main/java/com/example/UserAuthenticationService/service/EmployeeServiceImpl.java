/*
 *Author Name :P.Hemanth Sai Teja
 *Date:28-06-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.UserAuthenticationService.service;

import com.example.UserAuthenticationService.domain.Employee;
import com.example.UserAuthenticationService.exception.EmployeeExistAlready;
import com.example.UserAuthenticationService.exception.EmployeeNotFound;
import com.example.UserAuthenticationService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.ClassUtils.isPresent;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeRepository employeeRepository;
@Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmploy(Employee e) throws EmployeeExistAlready {
    if(employeeRepository.findById(e.getEcode()).isPresent()){
        throw new EmployeeExistAlready();
    }
        return employeeRepository.save(e);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByEmailAndPassword(String email, String password) throws EmployeeNotFound {
        return employeeRepository.findByEmailAndPassword(email, password);
    }



    @Override
    public List<Employee> getEmployeeByDname(String department) {
        return employeeRepository.findAllEmployeeFromDname(department);
    }
}
