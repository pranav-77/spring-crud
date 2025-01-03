package com.employee.crud.service;

import com.employee.crud.requestDto.AddressRequestDto;
import com.employee.crud.responseDto.AddressResponseDto;

import java.util.List;

public interface AddressService {
    AddressResponseDto add(AddressRequestDto addressRequestDto);

    List<AddressResponseDto> list();

    AddressResponseDto getById(int id);

    AddressResponseDto update(int id, AddressRequestDto addressRequestDto);

    void delete(int id);
}
