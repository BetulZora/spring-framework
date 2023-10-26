package com.cydeo.entity;

import com.cydeo.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="payments")
@Data
@NoArgsConstructor
public class Payment extends BaseEntity{
    private BigDecimal amount;
    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;
    private Status paymentStatus;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.paymentStatus = paymentStatus;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="paymentDetailId")
    private PaymentDetail paymentDetail;

    /*
    private Cart cart;
    private Customer customer;
    private Merchant merchant;

     */
}
