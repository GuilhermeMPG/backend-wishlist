package io.guimgp.backend_wishlist.project.domain.dto.user;

import io.guimgp.backend_wishlist.project.domain.dto.profile.ProfileResponseDTO;

public record GetUserResponseDTO(String username, String email, ProfileResponseDTO profile) {
}
