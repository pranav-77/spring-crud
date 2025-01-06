package com.employee.crud.requestDto;

import com.employee.crud.enumeration.EmployeeGender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {

    @NotBlank(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Name should contains only letters")
    private String name;

    @NotBlank(message = "Email should not be empty")
    @Email(message = "Invalid Email Format")
    private String email;

    @NotNull(message = "Number should not be null")
    @Pattern(regexp = "^(\\+91)?[6-9]\\d{9}$", message = "Check the phone number")
    private String phoneNo;

    @NotNull(message = "Salary should not be empty")
    private double salary;

    private EmployeeGender gender;

    @Valid
    private List<AddressRequestDto> address;
}
