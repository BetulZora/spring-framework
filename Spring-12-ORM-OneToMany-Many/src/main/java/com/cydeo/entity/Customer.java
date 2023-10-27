package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
public class Customer extends BaseEntity{

    private String address;
    private String email;
    private String name;
    @Column(name = "surName")
    private String lastName;
    private String userName;

    public Customer(String address, String email, String name, String lastName, String userName) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
    }

    @OneToMany(mappedBy = "customer")
    private List<Payment> paymentList;
}
