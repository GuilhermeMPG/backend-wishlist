package io.guimgp.backend_wishlist.project.presentation.controller;


import io.guimgp.backend_wishlist.project.domain.dto.user.GetUserResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.user.PutUserRequestDTO;
import io.guimgp.backend_wishlist.project.presentation.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserResponseDTO> getUserById(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId,
                                                             @RequestBody PutUserRequestDTO body) {
        return userService.updateUserById(userId, body);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") String userId, HttpServletRequest request) {
        return userService.deleteUserById(userId, request);
    }

}
