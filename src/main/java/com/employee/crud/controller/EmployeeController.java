package com.employee.crud.controller;

import com.employee.crud.requestDto.EmployeeRequestDto;
import com.employee.crud.responseDto.EmployeeResponseDto;
import com.employee.crud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeResponseDto add(@RequestBody @Valid EmployeeRequestDto requestDto) {
        return employeeService.add(requestDto);
    }

    @GetMapping("/search/{id}")
    public EmployeeResponseDto getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @GetMapping("/list")
    public List<EmployeeResponseDto> list() {
        return employeeService.list();
    }

    @PostMapping("/addData")
    public EmployeeResponseDto addWithAddress(@RequestBody EmployeeRequestDto requestDto){
        return employeeService.addWithAddress(requestDto);
    }

    @PutMapping("/update/{id}")
    public EmployeeResponseDto update(@PathVariable int id, @RequestBody EmployeeRequestDto requestDto) {
        return employeeService.update(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}

