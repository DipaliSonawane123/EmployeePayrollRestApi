package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmpDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import java.util.List;


/*Class for Object*/
@Entity
@Data
@NoArgsConstructor
@Table(name="employeepayroll.model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_Id")
   private Long employeeId;
    private String employeeName;
    private String profilePic;
    private String gender;
    private Long salary;
    private  LocalDate startDate;
    private String notes;
    @ElementCollection
    @CollectionTable(name="employee_department",joinColumns=@JoinColumn(name="ID"))
    @Column(name="Department")
    private List<String> department;

    public Model(EmpDto dto) {
        this.employeeName = dto.getEmployeeName();
        this.profilePic = dto.getProfilePic();
        this.gender = dto.getGender();
        this.salary = dto.getSalary();
        this.startDate = dto.getStartDate();
        this.notes = dto.getNotes();
        this.department = dto.getDepartment();
    }
}
