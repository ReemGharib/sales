package com.sales.sales.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sale> sales;
}
