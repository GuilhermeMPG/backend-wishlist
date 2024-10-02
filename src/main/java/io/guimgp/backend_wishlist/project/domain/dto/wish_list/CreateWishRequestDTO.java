package io.guimgp.backend_wishlist.project.domain.dto.wish_list;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateWishRequestDTO(

        @NotNull(message = "Name is required")
        @Size(min = 2, message = "Name must have at least 2 characters")
        String product_name,

        @Size(max = 1000, message = "Description must have until 1000 characters")
        String description,

        @DecimalMin(value = "0.00", inclusive = false, message = "Amount must be greater than zero")
        BigDecimal price,

        @Min(value = 0, message = "Minimum priority is 0")
        @Max(value = 100, message = "Maximum priority is 100")
        Integer priority

) {
}
