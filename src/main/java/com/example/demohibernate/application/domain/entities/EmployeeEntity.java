package com.example.demohibernate.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="employee")
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private int salary;

    public EmployeeEntity() {}

    public EmployeeEntity(String fname, String lname, int salary) {
        this.first_name = fname;
        this.last_name = lname;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

