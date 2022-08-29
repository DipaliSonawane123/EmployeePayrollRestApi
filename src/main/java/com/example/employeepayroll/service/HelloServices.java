package com.example.employeepayroll.service;

import com.example.employeepayroll.model.Model;
import com.example.employeepayroll.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Model> sayHelloById(long id) {
        return repository.findById(id);

    }
    public List<Model> sayAll(){
        return repository.findAll();
    }
    public Model editEmp(Model model, Long employeeId) {
        Model editdata = repository.findById(employeeId).orElse(null);
        if (editdata != null) {
            editdata.setEmployeeName(model.getEmployeeName());
            editdata.setDepartment(model.getDepartment());
            editdata.setEmployeeName(model.getEmployeeName());
            editdata.setProfilePic(model.getProfilePic());
            editdata.setGender(model.getGender());
            editdata.setEmployeeName(model.getEmployeeName());
            editdata.setSalary(model.getSalary());
            editdata.setStartDate(model.getStartDate());
            editdata.setNotes(model.getNotes());
            return repository.save(editdata);
        }
        else
            return null;
        }
    public void deleteById(Long employeeId) {
        repository.deleteById(employeeId);
    }
}




