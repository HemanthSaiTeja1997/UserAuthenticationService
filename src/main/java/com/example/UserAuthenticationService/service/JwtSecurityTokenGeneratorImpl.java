/*
 *Author Name :P.Hemanth Sai Teja
 *Date:28-06-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.UserAuthenticationService.service;

import com.example.UserAuthenticationService.domain.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> getSecurityToken(Employee employee) {
        String jwtToken = null;

        jwtToken = Jwts.builder()
                .setSubject(employee.getEmail())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        Map<String, String> map = new HashMap<>();
        map.put("token", jwtToken);
        map.put("message", "User Successfully logged in");
        return map;
    }
}
