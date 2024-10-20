package io.guimgp.backend_wishlist.project.presentation.service;

import io.guimgp.backend_wishlist.project.domain.dto.user.GetUserResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.user.PutUserRequestDTO;
import io.guimgp.backend_wishlist.project.domain.mapper.ProfileMapper;
import io.guimgp.backend_wishlist.project.domain.mapper.UserMapper;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import io.guimgp.backend_wishlist.project.domain.model.repository.UserRepository;
import io.guimgp.backend_wishlist.project.infrastructure.exceptions.EntityNotFoundCustomException;
import io.guimgp.backend_wishlist.project.infrastructure.security.SecurityFilter;
import io.guimgp.backend_wishlist.project.infrastructure.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileMapper profileMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    TokenService tokenService;

    @Autowired
    SecurityFilter securityFilter;


    public ResponseEntity<GetUserResponseDTO> getUserById(String id) {

        User user = this.userRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EntityNotFoundCustomException(id));

        return ResponseEntity.ok(new GetUserResponseDTO(user.getUsername(), user.getEmail(), profileMapper.profileToDto(user.getProfile())));


    }

    public ResponseEntity<Void> updateUserById(String id, PutUserRequestDTO body) {
        User user = userRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EntityNotFoundCustomException(id));


        if (body.username() != null) {
            user.setUsername(body.username());
        }
        if (body.email() != null) {
            user.setEmail(body.email());
        }
        if (body.password() != null) {
            user.setPassword(body.password());
        }

        userRepository.save(user);


        return ResponseEntity.ok().build();


    }

    public ResponseEntity<Void> deleteUserById(String id) {

        User user = userRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EntityNotFoundCustomException(id));
        userRepository.deleteById(UUID.fromString(id));
        return ResponseEntity.status(HttpStatus.OK).build();


    }
}
