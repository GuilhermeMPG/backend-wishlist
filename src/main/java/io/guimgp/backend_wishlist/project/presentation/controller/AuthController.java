package io.guimgp.backend_wishlist.project.presentation.controller;


import io.guimgp.backend_wishlist.project.domain.dto.LoginRequestDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import io.guimgp.backend_wishlist.project.domain.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {



    @PostMapping("/login")
    public ResponseEntity<Void> login (@RequestBody LoginRequestDTO){


    }

}
