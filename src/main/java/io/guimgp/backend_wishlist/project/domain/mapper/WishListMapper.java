package io.guimgp.backend_wishlist.project.domain.mapper;

import io.guimgp.backend_wishlist.project.domain.dto.wish_list.CreateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish_list.GetWishListResponseDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.WishList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface WishListMapper {
    @Mapping(target = "id", source = "id")
    GetWishListResponseDTO getWishListToDto (WishList wishList);

    WishList creatWish(CreateWishRequestDTO createWishRequestDTO);

}
