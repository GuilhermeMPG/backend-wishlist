package io.guimgp.backend_wishlist.project.domain.model.repository;
import io.guimgp.backend_wishlist.project.domain.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
}

