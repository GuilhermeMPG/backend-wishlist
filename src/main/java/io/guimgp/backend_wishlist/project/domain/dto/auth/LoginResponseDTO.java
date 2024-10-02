package io.guimgp.backend_wishlist.project.domain.dto.auth;

import java.util.UUID;

public record LoginResponseDTO (UUID user_id, String username, String token) {
}
