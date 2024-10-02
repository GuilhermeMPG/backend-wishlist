package io.guimgp.backend_wishlist.project.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class RestValidationErroMessage {
    private HttpStatus status;

    private Map<String, String> messsages;


}
