package com.example.employeepayroll.dto;

import com.example.employeepayroll.model.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ResponseDto {
   private String message;
   private Object object ;
   public ResponseDto(String string, Optional<Model> emp) {
       this.message=string;
       this.object = emp;
    }
    public ResponseDto(String s, List<Model> allEmp) {
        this.message=s;
        this.object = allEmp;
    }

    public ResponseDto(String string, String response) {
        this.message = string;
        this.object = response;
    }

    public ResponseDto(String s, Model emp) {
       this.message=s;
       this.object=emp;
    }
}
