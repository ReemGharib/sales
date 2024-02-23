package com.sales.sales.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_category")
    private String category;

    @Column(name = "product_creation_date")
    private LocalDate creationDate;
}
