package com.springboot.practice.JPA_Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.practice.Tables.Products;

@Repository
public interface Products_JPA_conn extends JpaRepository<Products, Integer> { 


}
