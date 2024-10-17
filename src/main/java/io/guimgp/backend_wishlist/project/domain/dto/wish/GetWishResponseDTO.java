package io.guimgp.backend_wishlist.project.domain.dto.wish;

import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;

import java.math.BigDecimal;

public record GetWishResponseDTO(Long id, String product_name, String description, BigDecimal price , OrderStatus status, Integer priority) {
}
