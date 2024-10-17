package io.guimgp.backend_wishlist.project.domain.mapper;

import io.guimgp.backend_wishlist.project.domain.dto.wish.CreateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish.GetWishResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish.UpdateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.Wish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper (componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WishMapper {
    @Mapping(target = "id", source = "id")
    GetWishResponseDTO getWishToDto (Wish wish);

    Wish creatWish(CreateWishRequestDTO createWishRequestDTO);

    @Mapping(target = "status", source = "status")
    void updateWishFromDto(UpdateWishRequestDTO dto, @MappingTarget Wish wish);

}
