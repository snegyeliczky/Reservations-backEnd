package com.codecool.reservationsbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String country;

    private String city;

    private String address;

    private Integer zipCode;


    @OneToOne(cascade = CascadeType.PERSIST)
    private Guest guest;
}