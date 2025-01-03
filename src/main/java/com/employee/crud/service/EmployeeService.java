package com.employee.crud.service;

import com.employee.crud.requestDto.EmployeeRequestDto;
import com.employee.crud.responseDto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto add(EmployeeRequestDto requestDto);

    EmployeeResponseDto getById(int id);

    List<EmployeeResponseDto> list();

    EmployeeResponseDto update(int id, EmployeeRequestDto requestDto);

    EmployeeResponseDto addWithAddress(EmployeeRequestDto requestDto);

    void delete(int id);
}
