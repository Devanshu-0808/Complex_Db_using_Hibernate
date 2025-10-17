package com.springboot.practice.Tables;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "PRODUCTS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Product_id;
    String Product_name;
    String description;
    Double Product_price;
    Integer Available_stock;

    @Temporal(TemporalType.TIMESTAMP)
    Date created_at = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy = "product2")
    @JsonIgnore
    List<Review> reviews;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    List<CartItems> cartsItems;

    @OneToMany(mappedBy = "product2")
    @JsonIgnore
    List<Order_item> ordersItem;
}
