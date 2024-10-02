package io.guimgp.backend_wishlist.project.presentation.controller;


import io.guimgp.backend_wishlist.project.domain.dto.profile.PutProfileRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.user.PutUserRequestDTO;
import io.guimgp.backend_wishlist.project.presentation.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PutMapping("{userId}/profile")
    public ResponseEntity<Void> updateProfileById(@PathVariable("userId") String userId,
                                               @RequestBody PutProfileRequestDTO body) {
        return profileService.updateProfileById(userId, body);
    }


}
