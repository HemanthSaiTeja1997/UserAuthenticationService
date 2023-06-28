/*
 *Author Name :P.Hemanth Sai Teja
 *Date:28-06-2023
 *Created With: IntelliJ IDEA Community Edition
 */

package com.example.UserAuthenticationService.domain;

import java.util.Objects;

public class Project {
    private int pcode;
    private String pname;
    private int durationInMonths;

    public Project() {
    }

    public Project(int pcode, String pname, int durationInMonths) {
        this.pcode = pcode;
        this.pname = pname;
        this.durationInMonths = durationInMonths;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return pcode == project.pcode && durationInMonths == project.durationInMonths && Objects.equals(pname, project.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcode, pname, durationInMonths);
    }

    @Override
    public String toString() {
        return "Project{" +
                "pcode=" + pcode +
                ", pname='" + pname + '\'' +
                ", durationInMonths=" + durationInMonths +
                '}';
    }
}

