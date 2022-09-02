package com.example.employeepayroll.cotroller;

import com.example.employeepayroll.dto.EmpDto;
import com.example.employeepayroll.dto.ResponseDto;
import com.example.employeepayroll.model.Model;
import com.example.employeepayroll.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class Controller {
    @Autowired
    IService service;

    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public String helloEmp() {
        return "Welcome To Employee payroll Application";
    }

    /**POST Api for to save the data to Repo  data*/
    @PostMapping("/post")
    public ResponseEntity<ResponseDto> addEmpData(@Valid @RequestBody EmpDto empData) {
        Model Emp = service.saveData(empData);
        ResponseDto reponseDTO = new ResponseDto("**Employee Data Added** ",  Emp);
        return new ResponseEntity<>(reponseDTO, HttpStatus.CREATED);
    }

    /**Api for Show mesaage using service layer*/
    @GetMapping("/service")
    public String serviceCall() {
        return service.helloMessage();
    }

    /**Api to get data using ID delete data*/
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDto> sayHelloById(@PathVariable Long employeeId) {
        Optional<Model> response = service.sayHelloById(employeeId);
        ResponseDto responseDto=new ResponseDto("***All Details of employee using Id***",response);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    /** Api fetch all data data*/
    @GetMapping("/findAll")
    public ResponseEntity<ResponseDto> sayToAll() {
        List<Model> allEmp = service.sayAll();
        ResponseDto responseDTO = new ResponseDto("** All Employee List ** ", allEmp);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**Api fot Edit data*/
    @PutMapping("/editemp/{employeeId}")
    public ResponseEntity<ResponseDto> editId(@Valid @RequestBody EmpDto dtomodel, @PathVariable Long employeeId) {
        Optional<Model>emp = Optional.ofNullable(service.editEmp(dtomodel, employeeId));
        ResponseDto responseDto = new ResponseDto("  Data edited successfully  ", emp);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);


    }
    /**Api fot delete data*/

    @DeleteMapping("/deleteemp/{employeeId}")
    public ResponseEntity<ResponseDto> deleteEmp(@PathVariable Long employeeId) {
         service.deleteById(employeeId);
        ResponseDto reponseDTO = new ResponseDto("** Employee Data deleted successfully ** ",  "employeeId:"+employeeId);
        return new ResponseEntity(reponseDTO, HttpStatus.ACCEPTED);
    }
    @GetMapping("/department/{department}")
    public ResponseEntity <ResponseDto> getEmployeeDataByDepartment(@PathVariable String department) {
        List<Model> empDataList = service.getEmployeesByDepartment(department);
        ResponseDto respDTO = new ResponseDto("Get Data By Department", empDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

}
