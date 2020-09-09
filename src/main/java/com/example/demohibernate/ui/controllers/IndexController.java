package com.example.demohibernate.ui.controllers;

import com.example.demohibernate.application.domain.entities.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    private static SessionFactory Factory;

    public IndexController() {

    }

    @GetMapping("test")
    public ModelAndView index(Model model) {
        return new ModelAndView("test");
    }

}
