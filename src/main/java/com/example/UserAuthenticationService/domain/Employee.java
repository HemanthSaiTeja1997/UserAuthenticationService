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
    private Department department;
    private List<Project> projects;

    public Employee() {
    }

    public Employee(String email, String password, int ecode, String ename, Department department, List<Project> projects) {
        this.email = email;
        this.password = password;
        this.ecode = ecode;
        this.ename = ename;
        this.department = department;
        this.projects = projects;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ecode == employee.ecode && Objects.equals(email, employee.email) && Objects.equals(password, employee.password) && Objects.equals(ename, employee.ename) && Objects.equals(department, employee.department) && Objects.equals(projects, employee.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, ecode, ename, department, projects);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ecode=" + ecode +
                ", ename='" + ename + '\'' +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }
}

