package io.guimgp.backend_wishlist.project.domain.model.repository;
import io.guimgp.backend_wishlist.project.domain.model.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}
