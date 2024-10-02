package io.guimgp.backend_wishlist.project.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Column(length = 100)
    @Size(max = 100, message = "First name must not exceed 100 characters")
    private String first_name;

    @Column(length = 100)
    @Size(max = 100, message = "Last name must not exceed 100 characters")
    private String last_name;


    private Date birth_date;

    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    @Column(length = 30)
    @Size(max = 30, message = "Phone number must not exceed 30 characters")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,}$", message = "Phone number must be valid")
    private String phone_number;

    @Size(max = 1000, message = "Bio must not exceed 1000 characters")
    private String bio;

}
