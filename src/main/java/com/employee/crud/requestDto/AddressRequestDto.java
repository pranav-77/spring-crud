package com.employee.crud.requestDto;

import com.employee.crud.model.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {
    @Pattern(regexp = "^[A-Za-z0-9\\s]+(?: [A-Za-z0-9\\s]+)*$", message = "Check the format of street")
    private String street;

    @Pattern(regexp = "^[A-Za-z\\s.\\-]+(?: [A-Za-z\\s.\\-]+)*$", message = "Check the city format")
    private String city;

    @Pattern(regexp = "^[A-Za-z\\s.\\-]+(?: [A-Za-z\\s.\\-]+)*$", message = "Check the state format")
    private String state;
    private Employee employee;
}
