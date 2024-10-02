package io.guimgp.backend_wishlist.project.presentation.controller;


import io.guimgp.backend_wishlist.project.domain.dto.auth.LoginRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.auth.LoginResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.auth.RegisterRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.auth.RegisterResponseDTO;
import io.guimgp.backend_wishlist.project.presentation.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@RequestBody LoginRequestDTO loginRequestDTO){
        return authService.login(loginRequestDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO body){

        return authService.register(body);
    }

}
