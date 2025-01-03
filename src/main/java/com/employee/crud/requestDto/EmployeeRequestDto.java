package com.employee.crud.requestDto;

import com.employee.crud.enumeration.EmployeeGender;
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
    private Long phoneNo;

    private double salary;
    private EmployeeGender gender;

    private List<AddressRequestDto> address;
}
