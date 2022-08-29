package com.example.employeepayroll.service;

import com.example.employeepayroll.model.Model;
import com.example.employeepayroll.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServices {
@Autowired
Repo repository ;

    public String helloMessage() {
            return "Welcome To employeepayroll";
        }
    public Model saveData(Model emp) {
        repository.save(emp);
        return emp;
    }
        }




