package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="Debit")
public class DebitAccount extends Account{
    private BigDecimal overDraftFree;
}
