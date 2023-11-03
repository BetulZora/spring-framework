package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Display all employees with email address "
    List<Employee> findByEmail(String email);

    // Display all employees with first name "" and last name "" and show all employees with an email address not null
    List<Employee> findByFirstNameAndLastNameAndEmailIsNotNull(String firstName, String lastName);

    // Display employee with a given first name and lastname, and also show employees matching an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // Display all employees that first name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where last name starts with ""
    List<Employee> findByLastNameStartingWith(String prefix);

    // Display all employees with salaries higher than a number
    List<Employee> findBySalaryGreaterThan(Integer salary);
   Integer countEmployeeBySalaryGreaterThan(Integer salary);

   // Display all employees with salaries less than a number
    List<Employee> findBySalaryLessThan(Integer salary);
    Integer countEmployeeBySalaryLessThanEqual(Integer salary);

    // Display all employees that have been hired between " and "
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salary is greater than or equal to X in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //display top 3 unique employees that is making less than X
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that do not have an email adress
    List<Employee> findByEmailIsNull();


}
