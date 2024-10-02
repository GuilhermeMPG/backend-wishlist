package io.guimgp.backend_wishlist.project.presentation.service;


import io.guimgp.backend_wishlist.project.domain.dto.profile.PutProfileRequestDTO;
import io.guimgp.backend_wishlist.project.domain.mapper.ProfileMapper;
import io.guimgp.backend_wishlist.project.domain.model.entity.Profile;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import io.guimgp.backend_wishlist.project.domain.model.repository.ProfileRepository;
import io.guimgp.backend_wishlist.project.infrastructure.exceptions.EntityNotFoundCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileService {

    @Autowired
    ProfileMapper profileMapper;

    @Autowired
    ProfileRepository profileRepository;


    public ResponseEntity<Void> updateProfileById(String id, PutProfileRequestDTO body) {
        Profile profile = profileRepository.findById(UUID.fromString(id)).orElseThrow(() -> new EntityNotFoundCustomException(id));

        profileMapper.updateProfileToEntity(body,profile);

        profileRepository.save(profile);


        return ResponseEntity.ok().build();


    }
}
