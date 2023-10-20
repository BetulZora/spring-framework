package com.cydeo.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name="students")
// use @Table(name="NewName") to change the datatable name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // use @Column(name="newName") to rename a column
    // the DB column will adjust for camelcase to new_name
    @Column(name="studentFirstName") // will adjust for camel case in DB
    private String firstName;
    private String lastName;
    private String email;


    // @Transient prevents Spring from including the field in the DB
    @Transient
    private String city;


    // These data types introduced in Java8. Rename columns
    @Column(name="DATE")
    private LocalDate birthDate;
    @Column(name="TIME")
    private LocalTime birthTime;
    @Column(name="TIMESTAMP")
    private LocalDate birthDateTime;

    // by default, the table created will take camel case, convert to lowercase separated by "_"
    // firstName becomes first_name



}
