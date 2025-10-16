package com.springboot.practice.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ORDER_ITEM")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer quantity;
    Double price;

    @ManyToOne
    @JoinColumn(name="Order_id")
    Orders order_id;

    @ManyToOne
    @JoinColumn(name="Product_id")
    Products product2;
}
