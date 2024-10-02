package io.guimgp.backend_wishlist.project.domain.dto.profile;

import java.util.Date;

public record ProfileResponseDTO(String address, String bio, Date birth_date, String first_name, String last_name, String phone_number) {
}
