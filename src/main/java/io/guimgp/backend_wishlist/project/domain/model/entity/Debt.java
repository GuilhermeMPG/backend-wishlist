package io.guimgp.backend_wishlist.project.domain.model.entity;

import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "debts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is required")
    private User user;

    @Column(nullable = false)
    @NotBlank(message = "Product name is required")
    @Size(max = 255, message = "Product name must not exceed 255 characters")
    private String product_name;

    @Size(max = 255, message = "Institution name must not exceed 255 characters")
    private String institution_name;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @Column(precision = 10, scale = 2, nullable = false)
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.00", inclusive = false, message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotNull(message = "Due date is required")
    @Future(message = "Due date must be in the future")
    private Date due_date;

    @Min(value = 1, message = "Total installment must be at least 1")
    private Integer total_installment = 1;

    @Min(value = 0, message = "Paid installment cannot be negative")
    private Integer paid_installment = 0;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    private Boolean recurring = false;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

}