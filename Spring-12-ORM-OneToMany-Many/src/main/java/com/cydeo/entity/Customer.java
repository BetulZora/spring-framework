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

    public Customer(String userName, String name, String surName, String email, String address) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.lastName = surName;
        this.userName = userName;
    }

    // Use the fetching attribute to restrict customer's relationship only to payment and not other relationships of payment
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Payment> paymentList;

}
