package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity {

   private String firstName;
   private String lastName;
   private String email;
   @Column(columnDefinition = "DATE")
   private LocalDate hireDate;
   private int salary;

   @Enumerated(EnumType.STRING)
   private Gender gender;

   // Because department is tied to another @Entity, this deserves special treatment
   // Use annotations to set the nature of the relationship in the database tables
   // in this case, one Employee can be a part of only one department. So this is a OneToOne relationship
  // choosing CascadeType.ALL because when the Employee is saved, want Department to be saved too.
   // can use @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "departmentId")
   private Department department;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "regionId")
   private Region region;

   // will uncomment these later
   //private int regionId;
   //


   public Employee(String firstName, String lastName, String email, LocalDate hireDate, int salary, Gender gender) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.hireDate = hireDate;
      this.salary = salary;
      this.gender = gender;
   }
}
