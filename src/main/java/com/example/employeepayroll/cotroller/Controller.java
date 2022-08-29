package com.example.employeepayroll.cotroller;

import com.example.employeepayroll.model.Model;
import com.example.employeepayroll.service.HelloServices;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
public class Controller {
    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
        public String helloEmp() {
            return "Welcome To Employee payroll Application";
        }
    @PostMapping("/post")
    public Model addEmpData(@RequestBody Model empData) {
        service.saveData(empData);
        return empData;
    }
    @Autowired
        HelloServices service;
        @GetMapping("/service")
        public String serviceCall() {
            return service.helloMessage();
        }
    }


