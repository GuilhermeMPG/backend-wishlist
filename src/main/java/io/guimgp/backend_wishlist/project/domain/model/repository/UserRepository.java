package io.guimgp.backend_wishlist.project.domain.model.repository;

import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID > {
}
