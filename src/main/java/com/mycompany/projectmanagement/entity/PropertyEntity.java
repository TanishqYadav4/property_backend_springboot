package com.mycompany.projectmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE" , nullable = false)
    private String title;
    @Column(name = "PROPERTY_DESCRIPTION" , nullable = false)
    private String description;
    @Column(name = "ADDRESS" , nullable = false)
    private String address;
    @Column(name = "PRICE" , nullable = false)
    private Double price;
}
