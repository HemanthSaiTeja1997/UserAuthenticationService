/*
 *Author Name :P.Hemanth Sai Teja
 *Date:28-06-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.UserAuthenticationService.domain;

import java.util.Objects;

public class Department {
    private int dcode;
    private String dname;

    public Department() {
    }

    public Department(int dcode, String dname) {
        this.dcode = dcode;
        this.dname = dname;
    }

    public int getDcode() {
        return dcode;
    }

    public void setDcode(int dcode) {
        this.dcode = dcode;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return dcode == that.dcode && Objects.equals(dname, that.dname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dcode, dname);
    }

    @Override
    public String toString() {
        return "Department{" +
                "dcode=" + dcode +
                ", dname='" + dname + '\'' +
                '}';
    }
}

