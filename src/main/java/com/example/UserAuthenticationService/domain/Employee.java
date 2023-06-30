/*
 *Author Name :P.Hemanth Sai Teja
 *Date:28-06-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.UserAuthenticationService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
@Document
public class Employee {
    @Id
    private int ecode;
    private String email;
    private String password;

    private String ename;
    private String department;


    public Employee() {
    }

    public Employee(int ecode, String email, String password, String ename, String department) {
        this.ecode = ecode;
        this.email = email;
        this.password = password;
        this.ename = ename;
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEcode() {
        return ecode;
    }

    public void setEcode(int ecode) {
        this.ecode = ecode;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ecode == employee.ecode && Objects.equals(email, employee.email) && Objects.equals(password, employee.password) && Objects.equals(ename, employee.ename) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ecode, email, password, ename, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ecode=" + ecode +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ename='" + ename + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

