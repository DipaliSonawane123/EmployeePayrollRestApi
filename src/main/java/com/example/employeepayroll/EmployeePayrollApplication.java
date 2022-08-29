package com.example.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class EmployeePayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollApplication.class, args);
    }

}
