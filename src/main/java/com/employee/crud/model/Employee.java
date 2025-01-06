package com.employee.crud.model;

import com.employee.crud.enumeration.EmployeeGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String phoneNo;

    private double salary;

    @Column(nullable = false)
    private EmployeeGender gender;

    @OneToMany(mappedBy = "employee")
    private List<Address> addresses;
}
