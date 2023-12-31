package com.cydeo.bootstrap;

import com.cydeo.entity.Course;
import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository)
    {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        // Display all regions in Canada using derived queries in the repository
        System.out.println("---------------------------+++++++++Region Start");
        System.out.println("In the DATA GENERATOR:" + regionRepository.findByCountry("Canada"));
        System.out.println(regionRepository.findDistinctByCountry("Canada"));
        System.out.println(regionRepository.findByCountryContaining("United"));
        System.out.println(regionRepository.findByCountryContainingOrderByRegion("United"));
        System.out.println(regionRepository.findTop2ByCountry("Canada"));

        System.out.println("---------------------------+++++++++Region End");
        System.out.println("---------------------------+++++++++Department Start");
        System.out.println(departmentRepository.findByDepartment("Furniture"));
        System.out.println(departmentRepository.findByDepartment("Toys"));
        System.out.println("Is:" +departmentRepository.findByDivisionIs("Health"));
        System.out.println("Equals:" +departmentRepository.findByDivisionEquals("Outdoors"));
        System.out.println(departmentRepository.findDistinctTop3ByDivisionContaining("Hea"));
        System.out.println("---------------------------+++++++++Department End");
        System.out.println("---------------------------+++++++++Employee Start");
        System.out.println(employeeRepository.findByEmail("ssymonds2@hhs.gov"));
        System.out.println(employeeRepository.findByFirstNameAndLastNameAndEmailIsNotNull("Sydney",  "Symonds"));
        System.out.println(employeeRepository.findByFirstNameAndLastNameOrEmail("Sydney",  "Symonds", "amcnee1@google.es"));
        //System.out.println(employeeRepository.findByLastNameStartingWith("Mc"));
        System.out.println(employeeRepository.countEmployeeBySalaryGreaterThan(100000));
        System.out.println(employeeRepository.countEmployeeBySalaryLessThanEqual(100000));
        //System.out.println(employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(100000));
        //System.out.println(employeeRepository.findByEmailIsNull());

        System.out.println("---------------------------+++++++++Employee End");
        System.out.println("---------------------------+++++++++Employee JPQL Start");
        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());
        System.out.println("---------------------------+++++++++Employee JPQL End");
        System.out.println("---------------------------+++++++++Courses Start");
        // System.out.println(courseRepository.findByCategory("Spring"));
        courseRepository.findByCategory("Spring").forEach(System.out::println);
        System.out.println("------------------------------------------------------");
        courseRepository.findByCategoryOrderByNameDesc("Spring").forEach(System.out::println);
        System.out.println(courseRepository.existsByName("Getting Started with Spring Cloud Kubernetes"));
        System.out.println("courseRepository.existsByName(\"JavaScript\") = " + courseRepository.existsByName("JavaScript"));
        System.out.println("courseRepository.countByCategory(\"Spring\") = " + courseRepository.countByCategory("Spring"));
        courseRepository.findByNameStartsWith("Rapid Spring Boot").forEach(System.out::println);
        System.out.println("------------------------------------------------------");
        //courseRepository.streamByCategory("Spring").forEach(System.out::println);
        System.out.println("---------------------------+++++++++Courses End");



    }
}
