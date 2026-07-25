package com.anuj.creatorstore.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String locality;

    private String address;

    private String city;

    private String state;

    private String pinCode;

    private String mobile;
}
