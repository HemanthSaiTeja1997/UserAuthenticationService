/*
 *Author Name :P.Hemanth Sai Teja
 *Date:28-06-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.UserAuthenticationService.controller;

import com.example.UserAuthenticationService.domain.Employee;
import com.example.UserAuthenticationService.exception.EmployeeExistAlready;
import com.example.UserAuthenticationService.exception.EmployeeNotFound;
import com.example.UserAuthenticationService.service.IEmployeeService;
import com.example.UserAuthenticationService.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
private IEmployeeService iEmployeeService;
private SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public EmployeeController(IEmployeeService iEmployeeService, SecurityTokenGenerator securityTokenGenerator) {
        this.iEmployeeService = iEmployeeService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> saveEmploy(@RequestBody Employee employee) throws EmployeeExistAlready {

    try{
        return new ResponseEntity<>(iEmployeeService.saveEmploy(employee), HttpStatus.CREATED);
    }
    catch (EmployeeExistAlready e)
    {
        throw new EmployeeExistAlready();
    }
    catch (Exception e){
        return new ResponseEntity<>("Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @GetMapping("/api/v1/fetchall")
    public ResponseEntity<?> fetchAll(){
    return new ResponseEntity<>(iEmployeeService.getEmployees(),HttpStatus.OK);
    }
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody Employee employee) throws EmployeeNotFound{
        try{
            iEmployeeService.getEmployeeByEmailAndPassword(employee.getEmail(), employee.getPassword());
            Map<String,String> secretkey=new HashMap<>();
            secretkey=securityTokenGenerator.getSecurityToken(employee);
            return new ResponseEntity<>(secretkey,HttpStatus.OK);
        }
        catch (EmployeeNotFound e){
            throw new EmployeeNotFound();
        }
        catch (Exception e){
           return new ResponseEntity<>("Network Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/api/v1/fetchbydept/{dname}")
    public ResponseEntity<?> fetchByDept(@PathVariable String dname){
        return new ResponseEntity<>(iEmployeeService.getEmployeeByDname(dname),HttpStatus.OK);
    }
}
