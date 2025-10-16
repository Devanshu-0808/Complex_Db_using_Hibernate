package com.springboot.practice.Tables;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PRODUCTS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Product_id;
    String Product_name;
    String description;
    Double Product_price;
    Integer Available_stock;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    Date created_at= new Date();

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy="product2")
    List<Review> reviews;

    @OneToMany(mappedBy = "product")
    List<CartItems> cartsItems;

    @OneToMany(mappedBy = "product2")
    List<Order_item> ordersItem;
}
