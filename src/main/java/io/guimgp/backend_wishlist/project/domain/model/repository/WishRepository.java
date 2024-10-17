package io.guimgp.backend_wishlist.project.domain.model.repository;
import io.guimgp.backend_wishlist.project.domain.model.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {
}
