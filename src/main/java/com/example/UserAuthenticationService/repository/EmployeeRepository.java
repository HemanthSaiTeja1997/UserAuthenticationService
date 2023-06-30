package com.example.UserAuthenticationService.repository;

import com.example.UserAuthenticationService.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
    Employee findByEmailAndPassword(String email, String password);


}
