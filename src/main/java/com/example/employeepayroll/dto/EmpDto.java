package com.example.employeepayroll.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class  EmpDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name is invalid ")
    @Size(min=3)
    String employeeName;
    @NotEmpty(message = "Profile Pic cannot be null.")
    String profilePic;
    @NotBlank(message = "Gender Cannot be Empty")
    String gender;
    @Min(value = 5000, message = "salary cannot be less than 5000.")
    @Max(value = 500000000, message = "Salary cannot be greater than 500000000.")
    Long salary;
    @NotBlank(message = "Department  Cannot be Empty")
    String department;
    @PastOrPresent(message = "Given Date is not valid maybe future date")
    @NotNull(message = "startDate should Not be Empty")
    LocalDate startDate;
    @NotEmpty (message = "notes Cannot be Empty")
    String notes;
}
