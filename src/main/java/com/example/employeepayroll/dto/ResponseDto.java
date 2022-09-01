package com.example.employeepayroll.dto;

import com.example.employeepayroll.model.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDto {
   private String message;
   private Object object ;
   public ResponseDto(String string, Model emp) {
       this.message=string;
       this.object = emp;
    }
    public ResponseDto(String s, List<Model> allEmp) {
        this.message=s;
        this.object = allEmp;
    }
}
