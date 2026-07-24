package com.anuj.creatorstore.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Name;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemRequest {
    @NotNull(message = "Product idis required")
    private Long productId;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message="Quantity must be at least 1")
    private Integer quantity;
}
