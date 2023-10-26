package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name="merchants")
@Data
@NoArgsConstructor
public class Merchant extends BaseEntity{
    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;

    // One Merchant can have more than one Payment
    // So this needs to be a Container or Collection
    @OneToMany(mappedBy = "merchant")
    private List<Payment> paymentList;
    // if you put the foreign key in Merchant, it will correspond to a list
    // it is better to put the foreign key in the payment table
    // IMPORTANT: in OneToMany relationship, ownership should always be given to the class that is Many

    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal commissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}
