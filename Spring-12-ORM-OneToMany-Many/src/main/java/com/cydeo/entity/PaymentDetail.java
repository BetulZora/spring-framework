package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="paymentDetails")
@Data
@NoArgsConstructor
public class PaymentDetail extends BaseEntity{
    private BigDecimal commissionAmount;
    private BigDecimal merchantPayoutAmount;
    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.commissionAmount = commissionAmount;
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.payoutDate = payoutDate;
    }

    @OneToOne(mappedBy = "paymentDetail", cascade = CascadeType.ALL)
    private Payment payment;
}
