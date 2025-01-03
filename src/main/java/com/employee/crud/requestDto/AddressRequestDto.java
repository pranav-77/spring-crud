package com.employee.crud.requestDto;

import com.employee.crud.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {
    private String street;
    private String city;
    private String state;
    private Employee employee;
}
