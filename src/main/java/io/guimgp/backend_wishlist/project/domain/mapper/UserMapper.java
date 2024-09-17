package io.guimgp.backend_wishlist.project.domain.mapper;

import io.guimgp.backend_wishlist.project.domain.dto.LoginResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.RegisterRequestDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    LoginResponseDTO loginResponseToDto(User user);
    User loginResponseToEntity(LoginResponseDTO loginResponseDTO);

    RegisterRequestDTO registerRequestToDto(User user);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    User registerRequestToEntity(RegisterRequestDTO registerRequestDTO);

}
