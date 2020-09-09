package com.example.demohibernate.application.models;

public class EmployeeModel{

    public int id;
    public String first_name;
    public String last_name;
    public int salary;

    public EmployeeModel() {}

    public EmployeeModel(String fname, String lname, int salary) {
        this.first_name = fname;
        this.last_name = lname;
        this.salary = salary;
    }

    public EmployeeModel(int id, String fname, String lname, int salary) {
        this.id = id;
        this.first_name = fname;
        this.last_name = lname;
        this.salary = salary;
    }
}

