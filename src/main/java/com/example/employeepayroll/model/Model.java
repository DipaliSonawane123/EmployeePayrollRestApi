package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmpDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
/*Class for Object*/
@Entity
@Data
@NoArgsConstructor
public class Model {
    @Id
    @GeneratedValue
    Long employeeId;
    String employeeName;
    String profilePic;
    String gender;
    Long salary;
    String department;
    Date startDate;
    String notes;
    public Model(EmpDto dto) {
        this.employeeName = dto.getEmployeeName();
        this.profilePic = dto.getProfilePic();
        this.gender = dto.getGender();
        this.salary = dto.getSalary();
        this.department = dto.getDepartment();
        this.startDate = dto.getStartDate();
        this.notes = dto.getNotes();
    }
}
