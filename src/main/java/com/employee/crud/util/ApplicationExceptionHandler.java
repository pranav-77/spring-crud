package com.employee.crud.util;

import com.employee.crud.exception.EmployeeNotFoundByIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundByIdException.class)
    public ResponseEntity<Object> employeeNotFoundById(EmployeeNotFoundByIdException exception) {
        Map<String,Object> map = new HashMap<>();
        map.put("status", HttpStatus.NOT_FOUND.value());
        map.put("message", exception.getMessage());
        map.put("root cause", "This exception occurs because employee is not found by the given id");
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)

}