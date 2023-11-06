package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    // Display all employees that do not have an email address
    List<Employee> findByEmailIsNull();



    // e is instance name of the Class Employee
    @Query("SELECT e FROM Employee e WHERE e.email='lcasarolib@plala.or.jp'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='lcasarolib@plala.or.jp'")
    Integer getEmployeeSalary();


    @Query("SELECT e FROM Employee e WHERE e.email =?1")
    Optional<Employee> getEmployeeDetail(String email);
    // Using Optional to avoid null pointer

    @Query("SELECT e FROM Employee e WHERE e.email= ?1 AND e.salary= ?2")
    Optional<Employee> getEmployeeDetail(String email, Integer salary);


    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    @Query("SELECT e FROM Employee e WHERE e.email is NULL")
    List<Employee> getEmployeeEmailIsNull();
    @Query("SELECT e FROM Employee e WHERE e.email is Not NULL")
    List<Employee> getEmployeeEmailIsNotNull();

    //Sort in Ascending order by default
    @Query("SELECT e from Employee e order by e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    //Sort in Descending
    @Query("SELECT e from Employee e order by e.salary DESC")
    List<Employee> getEmployeeSalaryOrderDesc();

    // Use a Native SQL query, not JPQL
    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);








}
