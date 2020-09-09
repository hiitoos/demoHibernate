package com.example.demohibernate.application.services;

import com.example.demohibernate.application.models.EmployeeModel;

import java.util.List;


public interface EmployeeService {
     void Insert(EmployeeModel employee);
     List<EmployeeModel> findAll();
     EmployeeModel findById(int id);
     EmployeeModel deleteById(int id);
     EmployeeModel editUser(int id);
}
