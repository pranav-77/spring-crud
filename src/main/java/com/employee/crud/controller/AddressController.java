package com.employee.crud.controller;

import com.employee.crud.requestDto.AddressRequestDto;
import com.employee.crud.responseDto.AddressResponseDto;
import com.employee.crud.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public AddressResponseDto add(@Valid @RequestBody AddressRequestDto addressRequestDto) {
        return addressService.add(addressRequestDto);
    }

    @GetMapping("/list")
    public List<AddressResponseDto> list() {
        return addressService.list();
    }

    @GetMapping("/search/{id}")
    public AddressResponseDto getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PutMapping("/update/{id}")
    public AddressResponseDto update(@PathVariable int id, @Valid @RequestBody AddressRequestDto addressRequestDto) {
        return addressService.update(id, addressRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }
}
