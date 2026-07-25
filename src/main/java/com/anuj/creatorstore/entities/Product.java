package com.anuj.creatorstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String name;

    private String description;

    private int mrpPrice;

    @NotNull(message="Price is required")
    @DecimalMin(value = "0.0", inclusive=false, message="Price must be greater than 0.0")
    @Column(nullable = false)
    private int sellingPrice;

    private int discountPercent;

    private int quantity;

    private String color;

    private int numRatings;

    @ElementCollection
    private List<String> images = new ArrayList<>();

    @ManyToOne
    private Category category;

    @ManyToOne
    private Seller seller;

    private LocalDateTime createdAt;

    private String sizes;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews= new ArrayList<>();

    @NotNull(message="Stock Quantity is required")
    @Min(value = 0, message="Stock cannot be less than 0")
    @Column(name="stock_quantity", nullable=false)
    private Integer stockQuantity;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
}
