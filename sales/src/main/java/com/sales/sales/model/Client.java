package com.sales.sales.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Reem Gh.
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sale> sales;
}
