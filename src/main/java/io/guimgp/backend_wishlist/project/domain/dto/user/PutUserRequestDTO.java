package io.guimgp.backend_wishlist.project.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record PutUserRequestDTO(


        @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
        String username,


        @Email(message = "Email should be valid")
        String email,

        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password

) {
}
