package com.anuj.creatorstore.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    @NotBlank(message="Customer name cannot be empty")
    private String customerName;

    @NotBlank(message="Email cannot be empty")
    @Email(message = "Enter a valid email")
    private String customerEmail;

    @Valid
    @NotEmpty(message="Order must contain at least one item")
    private List<OrderItemRequest> items;
}
