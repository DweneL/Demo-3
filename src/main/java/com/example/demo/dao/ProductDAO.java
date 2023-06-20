package com.example.demo.dao;


import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


//Two things go inside the bracket, the primary key and the product
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
