package io.guimgp.backend_wishlist.project.infrastructure.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;


import java.io.Serial;
import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundCustomException extends ResponseStatusException {
    @Serial
    private static final long serialVersionUID = 1L;

    public EntityNotFoundCustomException(HttpStatus status, String message) {
        super(status,message);
    }

    public EntityNotFoundCustomException(UUID id) {
        super(HttpStatus.NOT_FOUND,"Entity not found with id: " + id);
    }

    public EntityNotFoundCustomException(Long id) {
        super(HttpStatus.NOT_FOUND,"Entity not found with id: " + id);
    }
    public EntityNotFoundCustomException(String id) {
        super(HttpStatus.NOT_FOUND,"Entity not found with id: " + id);
    }
}