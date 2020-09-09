package com.example.demohibernate.application.repositories;

import com.example.demohibernate.application.domain.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeRepositoryInterface {
    void Insert(EmployeeEntity employee);
    List<EmployeeEntity> findAll();
    EmployeeEntity findById(int id);
    EmployeeEntity deleteById(int id);
    EmployeeEntity editUser(int id);
}
