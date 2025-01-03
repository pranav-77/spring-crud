package com.employee.crud.responseDto;

import com.employee.crud.enumeration.EmployeeGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
    private int id;
    private String name;
    private String email;
    private Long phoneNo;
    private double salary;
    private EmployeeGender gender;
    private List<AddressResponseDto> address;
}
