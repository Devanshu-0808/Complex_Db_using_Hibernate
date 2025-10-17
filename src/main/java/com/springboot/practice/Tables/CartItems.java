package com.springboot.practice.Tables;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
// removed unused import
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CART_ITEMS")
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
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    Carts cartId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    Products product;

}
