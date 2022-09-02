package com.example.employeepayroll.repo;

import com.example.employeepayroll.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Model , Long> {
    @Query(value="SELECT * FROM employeepayroll.employeepayroll_model, employeepayroll.employee_department WHERE employeepayroll_model.employee_id = id AND employee_department.department = :department", nativeQuery=true)
    List<Model> findEmployeesByDepartment(String department);
}


