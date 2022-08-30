package com.example.employeepayroll.dto;

import com.example.employeepayroll.model.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ResponseDto {
   private String message;
   private Object object ;
   public ResponseDto(String string, Model emp) {
       this.message=string;
       this.object = emp;
    }
}
