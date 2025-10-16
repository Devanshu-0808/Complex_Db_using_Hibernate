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
@Table(name="CART_ITEMS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItems {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer quantity;
    
    @ManyToOne
    @JoinColumn(name="cart_id")
    Carts cartId;


    @ManyToOne
    @JoinColumn(name="product_id")
    Products product;
    
}
