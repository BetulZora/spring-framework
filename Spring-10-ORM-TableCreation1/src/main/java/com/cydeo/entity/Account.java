package com.cydeo.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

// Not an @Entity because these will be visible in the children
@MappedSuperclass
public class Account {


    @Id
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
