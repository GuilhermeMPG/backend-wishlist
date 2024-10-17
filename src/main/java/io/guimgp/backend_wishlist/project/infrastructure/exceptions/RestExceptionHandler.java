package io.guimgp.backend_wishlist.project.infrastructure.exceptions;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice

public class RestExceptionHandler {


    @ExceptionHandler(value={MethodArgumentNotValidException.class})
    public ResponseEntity<RestValidationErroMessage> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RestValidationErroMessage(HttpStatus.BAD_REQUEST,errors));
    }

    @ExceptionHandler(ResponseStatusException.class) ResponseEntity<String> runtimeValidationExecpitions(ResponseStatusException ex){

        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());

    }


}


