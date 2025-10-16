package com.springboot.practice.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PAYMENTS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Enumerated(EnumType.STRING)
    PaymentStatus status;
    
    @Enumerated(EnumType.STRING)
    PaymentMethod method;
    
    Double amount;
    String transactionId;

    @OneToOne(mappedBy = "payment")
    @JoinColumn(name="order_id")
    Orders order_id2;

}
enum PaymentStatus{
    PENDING,
    COMPLETED,
    FAILED,
    REFUNDED
}
enum PaymentMethod{
    CREDIT_CARD,
    UPI,
    COD,
   
}
