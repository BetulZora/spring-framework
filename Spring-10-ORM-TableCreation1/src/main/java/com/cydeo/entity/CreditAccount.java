package com.cydeo.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;
import javax.persistence.Table;


@Entity
@Table(name="credit")
public class CreditAccount extends Account {

    BigDecimal creditLimit;

}
