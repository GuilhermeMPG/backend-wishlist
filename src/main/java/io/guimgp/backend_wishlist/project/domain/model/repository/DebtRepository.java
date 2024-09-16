package io.guimgp.backend_wishlist.project.domain.model.repository;
import io.guimgp.backend_wishlist.project.domain.model.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DebtRepository extends JpaRepository<Debt, Long> {
}
