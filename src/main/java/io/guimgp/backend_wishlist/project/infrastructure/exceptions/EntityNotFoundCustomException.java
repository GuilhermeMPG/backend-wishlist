package io.guimgp.backend_wishlist.project.infrastructure.exceptions;


import org.springframework.http.HttpStatus;


import java.io.Serial;
import java.util.UUID;

public class EntityNotFoundCustomException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public EntityNotFoundCustomException(HttpStatus status, String message) {
        super(message);
    }

    public EntityNotFoundCustomException(UUID id) {
        super("Entity not found with id: " + id);
    }

    public EntityNotFoundCustomException(Long id) {
        super("Entity not found with id: " + id);
    }
    public EntityNotFoundCustomException(String id) {
        super("Entity not found with id: " + id);
    }
}