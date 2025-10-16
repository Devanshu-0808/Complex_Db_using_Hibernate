package com.springboot.practice.Tables;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ORDERS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String orderDate;
    
    @Enumerated(EnumType.STRING)
    OrderStatus status;

    Double total_Amount;
    
    @ManyToOne()
    @JoinColumn(name="Shipping_Address_id")
    Address shipping_Address_id;

    @ManyToOne()
    @JoinColumn(name="User_id")
    Users user_id;

    @OneToMany(mappedBy="order_id")
    List<Order_item> order_items;

    @OneToOne
    Payments payment;
}
enum OrderStatus{
    PENDING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
