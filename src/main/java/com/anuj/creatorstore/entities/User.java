package com.anuj.creatorstore.entities;

import com.anuj.creatorstore.enums.User_Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;

    private String fullName;

    private String mobile;

    private User_Role role =  User_Role.ROLE_CUSTOMER;

    @OneToMany
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    private Set<Coupon> usedCoupons = new HashSet<>();
}
