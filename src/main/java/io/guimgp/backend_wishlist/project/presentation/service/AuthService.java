package io.guimgp.backend_wishlist.project.presentation.service;

import io.guimgp.backend_wishlist.project.domain.dto.auth.LoginRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.auth.LoginResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.auth.RegisterRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.auth.RegisterResponseDTO;
import io.guimgp.backend_wishlist.project.domain.mapper.UserMapper;

import io.guimgp.backend_wishlist.project.domain.model.entity.Profile;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import io.guimgp.backend_wishlist.project.domain.model.repository.ProfileRepository;
import io.guimgp.backend_wishlist.project.domain.model.repository.UserRepository;
import io.guimgp.backend_wishlist.project.infrastructure.exceptions.EntityNotFoundCustomException;
import io.guimgp.backend_wishlist.project.infrastructure.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO body) {
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new EntityNotFoundCustomException(HttpStatus.NOT_FOUND, "Email not found."));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {

            LoginResponseDTO foundUser = new LoginResponseDTO(user.getUser_id(), user.getUsername(), this.tokenService.generateToken(user));
            return ResponseEntity.ok(foundUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    public ResponseEntity<RegisterResponseDTO> register(RegisterRequestDTO body) {
        Optional<User> user = this.userRepository.findByEmail(body.email());

        if (user.isEmpty()) {
            User newUser;
            newUser = userMapper.registerRequestToEntity(body);
            newUser.setPassword(passwordEncoder.encode(body.password()));

            this.userRepository.save(newUser);

            Profile profile = new Profile();
            profile.setUser(newUser);
            profileRepository.save(profile);

            RegisterResponseDTO createdUser = new RegisterResponseDTO(newUser.getUsername(), this.tokenService.generateToken(newUser));
            return ResponseEntity.ok(createdUser);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
