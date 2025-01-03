package com.employee.crud.service.serviceImpl;

import com.employee.crud.exception.EmployeeNotFoundByIdException;
import com.employee.crud.model.Address;
import com.employee.crud.repository.AddressRepository;
import com.employee.crud.requestDto.AddressRequestDto;
import com.employee.crud.responseDto.AddressResponseDto;
import com.employee.crud.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressResponseDto add(AddressRequestDto addressRequestDto) {
        Address address = mapToEntity(addressRequestDto);
        address = addressRepository.save(address);
        return mapToResponse(address);
    }

    @Override
    public List<AddressResponseDto> list() {
        return addressRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public AddressResponseDto getById(int id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundByIdException("Employee not found"));
        return mapToResponse(address);
    }

    @Override
    public AddressResponseDto update(int id, AddressRequestDto addressRequestDto) {
        Address address = mapToEntity(addressRequestDto);
        address.setAddressId(id);
        try {
            address = addressRepository.save(address);
        } catch (Exception exception) {
            throw new EmployeeNotFoundByIdException("Employee not found");
        }
        return mapToResponse(address);
    }

    @Override
    public void delete(int id) {
        addressRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundByIdException("Employee not found in given id"));
        addressRepository.deleteById(id);
    }

    private AddressResponseDto mapToResponse(Address address) {
        AddressResponseDto addressResponseDto = new AddressResponseDto();
        addressResponseDto.setStreet(address.getStreet());
        addressResponseDto.setCity(address.getCity());
        addressResponseDto.setState(address.getState());

        return addressResponseDto;
    }

    public Address mapToEntity(AddressRequestDto requestDto) {
        return Address.builder()
                .street(requestDto.getStreet())
                .city(requestDto.getCity())
                .state(requestDto.getState())
                .employee(requestDto.getEmployee())
                .build();

    }
}
