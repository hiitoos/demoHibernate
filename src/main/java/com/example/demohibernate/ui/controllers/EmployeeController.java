package com.example.demohibernate.ui.controllers;

import com.example.demohibernate.application.models.EmployeeModel;
import com.example.demohibernate.application.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("insert")
    public ModelAndView insert(Model model){
        EmployeeModel employeeModel = new EmployeeModel ();
        employeeModel.first_name = "Braulio";
        employeeModel.last_name = "Combe";
        employeeModel.salary = 100;
        this.employeeService.Insert (employeeModel);
        return new ModelAndView ("employee.insert");
    }

    @GetMapping("showall")
    public ModelAndView showAll(Model model){
        EmployeeModel employeeModel = new EmployeeModel ();
        List<EmployeeModel> employees = this.employeeService.findAll ();
        return new ModelAndView ("employee.showall", "employees", employees);
    }

    @GetMapping("showid/{id}")
    public ModelAndView findById(Model model, @PathVariable("id") int id){
        EmployeeModel employeeModel = this.employeeService.findById (id);
        return new ModelAndView ("employee.profile", "employee", employeeModel);
    }

    @GetMapping("deleteid/{id}")
    public ModelAndView deleteById(Model model, @PathVariable("id") int id){
        EmployeeModel employeeModel = this.employeeService.deleteById (id);
        return new ModelAndView ("employee.delete", "employee", employeeModel);
    }

    @GetMapping("edituser/{id}")
    public ModelAndView editUser(Model model, @PathVariable("id") int id){
        EmployeeModel employeeModel = this.employeeService.findById (id); //Falta control errores por si peta por falta de ID
        model.addAttribute("employee.edit", employeeModel);
        return new ModelAndView ("employee.edit", "employee", employeeModel);
    }

    @RequestMapping(value="update/{id}", method = RequestMethod.POST)
    public ModelAndView update(Model model, @PathVariable("id") int id,
                               @RequestParam ("first_name") String firstname,
                               @RequestParam ("last_name") String lastname,
                               @RequestParam ("salary") int salary){
        //EmployeeModel employeeModel = this.employeeService.findById (id); //Falta control errores por si peta por falta de ID
        //this.employeeService.Insert (employeeModel);
        System.out.println (firstname + lastname + salary);
        EmployeeModel employeeModel = new EmployeeModel (id, firstname, lastname, salary);
        this.employeeService.Insert (employeeModel);
        return new ModelAndView ("employee.insert");
    }
}
