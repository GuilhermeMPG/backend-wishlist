package io.guimgp.backend_wishlist.project.presentation.service;

import io.guimgp.backend_wishlist.project.domain.dto.LoginRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.LoginResponseDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import io.guimgp.backend_wishlist.project.domain.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<LoginResponseDTO> login (LoginRequestDTO body){
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }



    }
}
