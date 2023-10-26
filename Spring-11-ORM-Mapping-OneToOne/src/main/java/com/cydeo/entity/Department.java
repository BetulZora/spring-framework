package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="departments")
@Data
@NoArgsConstructor
public class Department extends BaseEntity {


    private String department;
    private String division;

    // using the "mappedBy" attribute, creating bidirectional association with Employee
    // however, this also means, that the foreign key is owned by the other class (by Employee"
    // mappedBy = "fieldName" -> fieldName must match the Department field in Employee
    @OneToOne(mappedBy = "department")
    private Employee employee;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
