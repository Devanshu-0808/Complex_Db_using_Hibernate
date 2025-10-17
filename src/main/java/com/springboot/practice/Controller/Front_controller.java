package com.springboot.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practice.JPA_Repositories.Products_JPA_conn;
import com.springboot.practice.Tables.Products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class Front_controller {
      @Autowired
       Products_JPA_conn p;
       
      @Autowired
      Products p1;

      @GetMapping("/Getall")
      @ResponseBody
      public List<Products> getMethodName() {
          return p.findAll();
      }
}
