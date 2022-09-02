package com.example.employeepayroll.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
public class  EmpDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name is invalid ")
    @Size(min=3)
    private String employeeName;
    @NotEmpty(message = "Profile Pic cannot be null.")
    private String profilePic;
    @NotBlank(message = "Gender Cannot be Empty")
    private  String gender;
    @Min(value = 5000, message = "salary cannot be less than 5000.")
    @Max(value = 500000000, message = "Salary cannot be greater than 500000000.")
    private Long salary;
    @NotNull(message = "startDate should Not be Empty")
    private LocalDate startDate;
    @NotEmpty (message = "notes Cannot be Empty")
    private String notes;
    private List<String> department;
}
