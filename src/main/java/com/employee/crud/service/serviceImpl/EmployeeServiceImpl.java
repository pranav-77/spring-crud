package com.employee.crud.service.serviceImpl;

import com.employee.crud.exception.EmployeeNotFoundByIdException;
import com.employee.crud.model.Address;
import com.employee.crud.model.Employee;
import com.employee.crud.repository.AddressRepository;
import com.employee.crud.repository.EmployeeRepository;
import com.employee.crud.requestDto.EmployeeRequestDto;
import com.employee.crud.responseDto.AddressResponseDto;
import com.employee.crud.responseDto.EmployeeResponseDto;
import com.employee.crud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public EmployeeResponseDto add(EmployeeRequestDto requestDto) {
        Employee employee = mapToEntity(requestDto);
        employee = employeeRepository.save(employee);
        log.info("Adding Data");
        return mapToResponse(employee);
    }

    @Override
    public EmployeeResponseDto getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundByIdException("No details found"));
        log.info("Getting data by id");
        return mapToResponse(employee);
    }

    @Override
    public List<EmployeeResponseDto> list() {
        log.info("Getting list of employees");
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public EmployeeResponseDto update(int id, EmployeeRequestDto requestDto) {
        Employee employee = mapToEntity(requestDto);
        employee.setId(id);
        try {
            employee = employeeRepository.save(employee);
        } catch (ObjectOptimisticLockingFailureException e) {
            throw new EmployeeNotFoundByIdException("No Details found");
        }
        log.info("Updating data");
        return mapToResponse(employee);
    }

    @Override
    public EmployeeResponseDto addWithAddress(EmployeeRequestDto requestDto) {
        Employee emp = mapToEntity(requestDto);
        List<Address> addresses = requestDto.getAddress().stream().map(e ->
                Address.builder()
                        .street(e.getStreet())
                        .city(e.getCity())
                        .state(e.getState())
                        .employee(emp)
                        .build()).toList();
        emp.setAddresses(addresses);
        employeeRepository.save(emp);
        addressRepository.saveAll(addresses);
        log.info("Adding data with address");
        return mapToResponse(emp);
    }

    @Override
    public void delete(int id) {
        employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundByIdException("Employee not found in given id"));
        log.info("Deleting data");
        employeeRepository.deleteById(id);
    }

    private EmployeeResponseDto mapToResponse(Employee employee) {
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setId(employee.getId());
        responseDto.setName(employee.getName());
        responseDto.setEmail(employee.getEmail());
        responseDto.setSalary(employee.getSalary());
        responseDto.setPhoneNo(employee.getPhoneNo());
        responseDto.setGender(employee.getGender());
        responseDto.setAddress(mapToAddressResponse(employee.getAddresses()));

        return responseDto;
    }

    private List<AddressResponseDto> mapToAddressResponse(List<Address> address) {
        if (address == null)
            return null;

        return address.stream().map(e -> {
            AddressResponseDto addressResponseDto = new AddressResponseDto();
            addressResponseDto.setStreet(e.getStreet());
            addressResponseDto.setCity(e.getCity());
            addressResponseDto.setState(e.getState());
            return addressResponseDto;
        }).toList();
    }

    private Employee mapToEntity(EmployeeRequestDto requestDto) {
        Employee employee = new Employee();
        employee.setName(requestDto.getName());
        employee.setEmail(requestDto.getEmail());
        employee.setSalary(requestDto.getSalary());
        employee.setPhoneNo(requestDto.getPhoneNo());
        employee.setGender(requestDto.getGender());
        return employee;
    }
}
