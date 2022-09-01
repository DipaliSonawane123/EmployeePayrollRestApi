package com.example.employeepayroll.exception;
import com.example.employeepayroll.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
@Slf4j
public class EmployeeExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errmsg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto respDTO = new ResponseDto("Exception while processing rest request", errmsg.toString());
        return new ResponseEntity(respDTO, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeeException exception){
        ResponseDto respDTO = new ResponseDto("Exception while processing REST request",
                exception.getMessage());
        return new ResponseEntity(respDTO, HttpStatus.BAD_REQUEST);
    }

}






