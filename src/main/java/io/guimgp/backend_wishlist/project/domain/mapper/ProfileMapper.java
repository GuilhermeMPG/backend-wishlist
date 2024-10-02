package io.guimgp.backend_wishlist.project.domain.mapper;

import io.guimgp.backend_wishlist.project.domain.dto.profile.ProfileResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.profile.PutProfileRequestDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.Profile;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileResponseDTO profileToDto (Profile profile);

    Profile  profileToEntity (PutProfileRequestDTO putProfileRequestDTO);

    void updateProfileToEntity(PutProfileRequestDTO dto, @MappingTarget Profile profile);
}
