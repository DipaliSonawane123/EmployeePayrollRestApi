package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmpDto;
import com.example.employeepayroll.model.Model;
import java.util.List;
import java.util.Optional;

public interface IService {
     String helloMessage();
     Model saveData(EmpDto emp);
     Optional<Model> sayHelloById(Long id);
    List<Model> sayAll();
     Model editEmp( EmpDto model, Long employeeId);
     void deleteById(Long employeeId);
     List<Model> getEmployeesByDepartment(String department);
}
