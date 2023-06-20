package com.example.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Library that does that is called hibernate
@Data
@NoArgsConstructor
@AllArgsConstructor
//this is a class i want to put in mt data base @entity
@Entity
//@ID means thats the primary key, always above the line its annotating
//This class creates a table, and auto increments it

public class Product {

    @Id
    //Generated values autoIncrements
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private double price;
    private int quantityInStock;
    private boolean isDiscounted;
}
