package com.springboot.practice.Tables;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="REVIEW")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer rating;
    String comment;
   
    
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt=new Date();

    @ManyToOne
    @JoinColumn(name="User_id")
    Users user2;


    @ManyToOne
    @JoinColumn(name="Product_id")
    Products product2;

}
