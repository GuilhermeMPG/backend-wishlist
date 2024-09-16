package io.guimgp.backend_wishlist.project.domain.model.entity;

import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @Column(length = 100)
    private String first_name;

    @Column(length = 100)
    private String last_name;

    private Date birth_date;

    private String address;

    @Column(length = 30)
    private String phone_number;


    private String bio;


}
