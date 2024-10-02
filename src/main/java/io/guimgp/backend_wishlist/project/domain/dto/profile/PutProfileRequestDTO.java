package io.guimgp.backend_wishlist.project.domain.dto.profile;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;


import java.util.Date;

public record PutProfileRequestDTO(


        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
        String first_name,


        @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
        String last_name,

        Date birth_date,


        @Size(max = 200, message = "Address must not exceed 200 characters")
        String address,

        @Pattern(regexp = "^\\+?[0-9. ()-]{7,}$", message = "Phone number must be valid") // Basic pattern for phone number
        String phone_number,

        @Size(max = 1000, message = "Bio must not exceed 1000 characters")
        String bio

) {
}