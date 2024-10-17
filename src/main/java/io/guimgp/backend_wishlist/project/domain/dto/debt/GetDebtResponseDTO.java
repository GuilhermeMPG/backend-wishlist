package io.guimgp.backend_wishlist.project.domain.dto.debt;

import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;
import org.springframework.http.HttpStatusCode;

import java.math.BigDecimal;
import java.util.Date;

public record GetDebtResponseDTO(Long id,
                                 String product_name,
                                 String institution_name,
                                 String description,
                                 BigDecimal amount,
                                 Date due_date,
                                 Integer total_installment,
                                 Integer paid_installment,
                                 OrderStatus status,
                                 Boolean recurring
) {
}
