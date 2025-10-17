package com.springboot.practice.Tables;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="USERS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;
    @Temporal(TemporalType.TIMESTAMP)
    Date created_at = new Date();
     
    @OneToMany(mappedBy="user1")
     @JsonIgnore
    List<Address> address;

    @OneToOne(mappedBy="user_cart")
    @JsonIgnore
    Carts cart;

    @OneToMany(mappedBy="user_id")
 @JsonIgnore
    List<Orders> orders;

    @OneToMany(mappedBy="user2")
     @JsonIgnore
    List<Review> reviews;

}
enum Role{
    CUSTOMER,
    ADMIN
}


