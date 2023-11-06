package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "departments")
//@NamedQuery(name="Department.findMyDepartment",
//query = "select d from Department d WHERE d.division=?1")
public class Department{

    @Id
    private String department;

    private String division;
}
