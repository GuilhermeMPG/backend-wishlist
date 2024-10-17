package io.guimgp.backend_wishlist.project.domain.dto.debt;

import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

public record CreateDebtRequestDTO (

        @NotBlank(message = "Product name is required")
        @Size(max = 255, message = "Product name must not exceed 255 characters")
        String product_name,

        @Size(max = 255, message = "Institution name must not exceed 255 characters")
        String institution_name,

        @Size(max = 1000, message = "Description must not exceed 1000 characters")
        String description,

        @NotNull(message = "Amount is required")
        @DecimalMin(value = "0.00", inclusive = false, message = "Amount must be greater than zero")
        BigDecimal amount,

        @NotNull(message = "Due date is required")
        @Future(message = "Due date must be in the future")
        Date due_date,

        @Min(value = 1, message = "Total installment must be at least 1")
        Integer total_installment,

        @Min(value = 0, message = "Paid installment cannot be negative")
        Integer paid_installment,

        @NotNull(message = "Order status is required")
        OrderStatus status,

        Boolean recurring
) {
}
