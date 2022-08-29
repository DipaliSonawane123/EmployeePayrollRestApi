package com.example.employeepayroll.cotroller;

import com.example.employeepayroll.model.Model;
import com.example.employeepayroll.repo.Repo;
import com.example.employeepayroll.service.HelloServices;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class Controller {
    @Autowired
    HelloServices service;
    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String helloEmp() {
        return "Welcome To Employee payroll Application";
    }

    @PostMapping("/post")
    public Model addEmpData(@RequestBody Model empData) {
        service.saveData(empData);
        return empData;
    }

    @GetMapping("/service")
    public String serviceCall() {
        return service.helloMessage();
    }

    @GetMapping("/get/{employeeId}")
    public Optional<Model> sayHelloById(@PathVariable long employeeId) {
        Optional<Model> response = service.sayHelloById(employeeId);
        return response;

    }

    @GetMapping("/findAll")
    public List<Model> sayToAll() {
        List<Model> response = service.sayAll();
        return response;
    }

    @PutMapping("/edit/{employeeId}")
    public Model editId(@RequestBody Model model, @PathVariable Long employeeId) {
        service.editEmp(model, employeeId);
        return model;
    }
    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmp(@PathVariable Long employeeId) {
        service.deleteById(employeeId);
        return "Employee Data Deleted......";
    }
}
