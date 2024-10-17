package io.guimgp.backend_wishlist.project.domain.model.entity;

import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;


@Entity
@Table(name = "wishes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String product_name;

    @Size(max = 1000, message = "Description must have until 1000 characters")
    private String description;

    @Column(precision = 10, scale = 2)
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.00", inclusive = false, message = "Amount must be greater than zero")
    private BigDecimal price = BigDecimal.valueOf(0.00);

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'PENDING'")
    private OrderStatus status = OrderStatus.PENDING;

    @Min(value = 0, message = "Priority must be at least 0")
    @Max(value = 100, message = "Priority must not exceed 100")
    private Integer priority = 0;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;





}
