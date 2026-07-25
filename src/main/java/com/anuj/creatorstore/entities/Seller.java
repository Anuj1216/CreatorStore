package com.anuj.creatorstore.entities;

import com.anuj.creatorstore.enums.AccountStatus;
import com.anuj.creatorstore.enums.User_Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String sellerName;

    private String mobile;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Embedded
    private BusinessDetails businessDetails = new BusinessDetails();

    @Embedded
    private BankDetails bankDetails = new BankDetails();

    @OneToOne(cascade = CascadeType.ALL)
    private Address pickupAddress = new  Address();

    private String GSTIN;

    private User_Role role=User_Role.ROLE_SELLER;

    private boolean isEmailVerified =false;

    private AccountStatus accountStatus = AccountStatus.PENDING_VERIFICATION;

}