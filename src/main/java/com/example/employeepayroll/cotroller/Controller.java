package com.example.employeepayroll.cotroller;
import com.example.employeepayroll.dto.EmpDto;
import com.example.employeepayroll.dto.ResponseDto;
import com.example.employeepayroll.model.Model;
import com.example.employeepayroll.service.HelloServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    /*Api for to save the data to Repo  data*/
    @PostMapping("/post")
    public ResponseEntity<ResponseDto> addEmpData(@RequestBody EmpDto empData) {
        Model Emp = service.saveData(empData);
        ResponseDto reponseDTO= new ResponseDto("**Employee Data Added** ",Emp);
        return new ResponseEntity(reponseDTO, HttpStatus.OK);
    }
    /*Api for Show mesaage using service layer*/
    @GetMapping("/service")
    public String serviceCall() {
        return service.helloMessage();
    }
    /*Api to get data using ID delete data*/
    @GetMapping("/get/{employeeId}")
    public Optional<Model> sayHelloById(@PathVariable Long employeeId) {
        Optional<Model> response = service.sayHelloById(employeeId);
        return response;

    }
    /*Api feach all data data*/
    @GetMapping("/findAll")
    public List<Model> sayToAll() {
        List<Model> response = service.sayAll();
        return response;
    }
    /*Api fot Edit data*/
    @PutMapping("/editemp/{employeeId}")
    public Model editId(@RequestBody Model model, @PathVariable Long employeeId) {
       Model emp= service.editEmp(model, employeeId);
        return emp;
    }
   /*Api fot delete data*/
    @DeleteMapping("/deleteemp/{employeeId}")
    public String deleteEmp(@PathVariable Long employeeId) {
        service.deleteById(employeeId);
        return "***********Employee Data Deleted**********";
    }
}
