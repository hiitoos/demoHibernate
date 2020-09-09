package com.example.demohibernate.application.services;

import com.example.demohibernate.application.domain.entities.EmployeeEntity;
import com.example.demohibernate.application.domain.factories.EmployeeFactory;
import com.example.demohibernate.application.models.EmployeeModel;
import com.example.demohibernate.application.repositories.EmployeeRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepositoryInterface EmployeeRepository;

    public EmployeeServiceImplementation(EmployeeRepositoryInterface employeeRepositoryInterface) {
        this.EmployeeRepository = employeeRepositoryInterface;
    }

    @Override
    public void Insert(EmployeeModel employeeModel) {
        EmployeeFactory employeeFactory = new EmployeeFactory ();

        if (employeeModel.id != 0) {
            EmployeeEntity actualEmployee = this.EmployeeRepository.findById (employeeModel.id);
            actualEmployee.setFirst_name (employeeModel.first_name);
            actualEmployee.setLast_name (employeeModel.last_name);
            actualEmployee.setSalary (employeeModel.salary);
            this.EmployeeRepository.Insert (actualEmployee);
        }
        else {
            EmployeeEntity employeeEntity = employeeFactory.createEntity (employeeModel);
            this.EmployeeRepository.Insert (employeeEntity);
        }
    }

    @Override
    public List<EmployeeModel> findAll() {
        EmployeeFactory employeeFactory = new EmployeeFactory ();
        List<EmployeeEntity> employeeEntities = this.EmployeeRepository.findAll ();
        List<EmployeeModel> employeeModels = new ArrayList<> ();
        for (EmployeeEntity employeeValues : employeeEntities){
            employeeModels.add (employeeFactory.createModel (employeeValues));
        }
        return employeeModels;
    }

    @Override
    public EmployeeModel findById(int id) {
        EmployeeEntity employeeEntity = this.EmployeeRepository.findById (id);
        if (employeeEntity == null) return null;
        EmployeeFactory employeeFactory = new EmployeeFactory ();
        EmployeeModel employeeModel = employeeFactory.createModel (employeeEntity);
        return employeeModel;
    }

    @Override
    public EmployeeModel deleteById(int id) {
        EmployeeEntity employeeEntity = this.EmployeeRepository.deleteById (id);
        if (employeeEntity == null) return null;
        EmployeeFactory employeeFactory = new EmployeeFactory ();
        EmployeeModel employeeModel = employeeFactory.createModel (employeeEntity);
        return employeeModel;    }

    @Override
    public EmployeeModel editUser(int id) {
        EmployeeEntity employeeEntity = this.EmployeeRepository.editUser (id);
        EmployeeFactory employeeFactory = new EmployeeFactory ();
        EmployeeModel employeeModel = employeeFactory.createModel(employeeEntity);
        return employeeModel;
    }
}
