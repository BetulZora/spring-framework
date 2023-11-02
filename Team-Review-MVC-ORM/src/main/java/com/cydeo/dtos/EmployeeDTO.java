package com.cydeo.dtos;

import com.cydeo.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmployeeDTO {

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String City;
    private State state;
    private String zipCode;

}
