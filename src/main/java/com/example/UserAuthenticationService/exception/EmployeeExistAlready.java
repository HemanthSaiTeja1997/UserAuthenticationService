/*
 *Author Name :P.Hemanth Sai Teja
 *Date:28-06-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.UserAuthenticationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Employee With Specified EmployeeCode Already Exists")
public class EmployeeExistAlready extends Exception {
}
