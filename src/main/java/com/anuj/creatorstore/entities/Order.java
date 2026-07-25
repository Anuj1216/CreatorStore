package com.anuj.creatorstore.entities;

import com.anuj.creatorstore.enums.OrderStatus;
import com.anuj.creatorstore.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    @ManyToOne
    private User user;

    private Long sellerId;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    private Address shippingAddress;

    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();

    private double totalMrpPrice;

    private Integer totalSellingPrice;

    private Integer discount;

    private OrderStatus orderStatus;

    private int totalItem;

    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    private LocalDateTime orderDate= LocalDateTime.now();

    private LocalDateTime deliveryDate= LocalDateTime.now().plusDays(7);
}
