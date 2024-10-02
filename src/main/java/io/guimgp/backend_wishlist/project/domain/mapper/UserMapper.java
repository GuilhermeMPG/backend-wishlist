package io.guimgp.backend_wishlist.project.domain.mapper;

import io.guimgp.backend_wishlist.project.domain.dto.user.GetUserResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.auth.LoginResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.user.PutUserRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.auth.RegisterRequestDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProfileMapper.class)
public interface UserMapper {

    LoginResponseDTO loginResponseToDto(User user);

    User loginResponseToEntity(LoginResponseDTO loginResponseDTO);

    RegisterRequestDTO registerRequestToDto(User user);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    User registerRequestToEntity(RegisterRequestDTO registerRequestDTO);

    @Mapping(target = "profile", source = "profile")
    GetUserResponseDTO getUserToDto (User user);

    PutUserRequestDTO putUserToDto (User user);

}
