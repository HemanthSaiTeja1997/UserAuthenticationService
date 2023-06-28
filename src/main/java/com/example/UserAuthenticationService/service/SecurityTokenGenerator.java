package com.example.UserAuthenticationService.service;

import com.example.UserAuthenticationService.domain.Employee;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String, String> getSecurityToken(Employee employee);
}
