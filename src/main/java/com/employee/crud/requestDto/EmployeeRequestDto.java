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

    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Name should contains only letters")
    private String name;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Invalid Email Format")
    private String email;

    @NotEmpty(message = "Number should not be null")
    private List<@Pattern(regexp = "^(\\+91)?[6-9]\\d{9}$", message = "Check the phone number") String> phoneNo;

    @NotNull(message = "Salary should not be empty")
    @Min(value = 10000, message = "Should not be lesser than 10000")
    @Max(value = 100000, message = "Should not be greater than 100000")
    private double salary;

    private EmployeeGender gender;

    @Valid
    private List<AddressRequestDto> address;
}
