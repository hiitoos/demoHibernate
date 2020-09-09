package com.example.demohibernate.application.domain.factories;

import com.example.demohibernate.application.domain.entities.EmployeeEntity;
import com.example.demohibernate.application.models.EmployeeModel;

public class EmployeeFactory {
    public EmployeeEntity createEntity(EmployeeModel employeeModel){
        EmployeeEntity employeeEntity = new EmployeeEntity (employeeModel.first_name, employeeModel.last_name, employeeModel.salary);
        return employeeEntity;
    }

    public EmployeeModel createModel(EmployeeEntity employeeEntity){
        EmployeeModel employeeModel = new EmployeeModel (employeeEntity.getId (), employeeEntity.getFirstName (), employeeEntity.getLastName (), employeeEntity.getSalary ());
        return employeeModel;
    }

}
