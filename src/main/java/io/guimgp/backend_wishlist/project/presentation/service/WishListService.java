package io.guimgp.backend_wishlist.project.presentation.service;

import io.guimgp.backend_wishlist.project.domain.dto.wish_list.CreateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish_list.GetWishListResponseDTO;
import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;
import io.guimgp.backend_wishlist.project.domain.mapper.WishListMapper;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import io.guimgp.backend_wishlist.project.domain.model.entity.WishList;
import io.guimgp.backend_wishlist.project.domain.model.repository.UserRepository;
import io.guimgp.backend_wishlist.project.domain.model.repository.WishListRepository;
import io.guimgp.backend_wishlist.project.infrastructure.exceptions.EntityNotFoundCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WishListService {

    @Autowired
    WishListMapper wishListMapper;

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    UserRepository userRepository;


    public ResponseEntity<GetWishListResponseDTO> getWishById(String wishId) {

        WishList wishList = this.wishListRepository.findById(Long.parseLong(wishId)).orElseThrow(() -> new EntityNotFoundCustomException(wishId));

        return ResponseEntity.ok(wishListMapper.getWishListToDto(wishList));
    }

    public ResponseEntity<Void> createWish(String userId, CreateWishRequestDTO body) {

        User user = this.userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new EntityNotFoundCustomException(userId));

        WishList wish = wishListMapper.creatWish(body);

        wish.setUser(user);

        wishListRepository.save(wish);

        return ResponseEntity.ok().build();


    }

    public List<GetWishListResponseDTO> listWishes(String userId) {
        User user = this.userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new EntityNotFoundCustomException(userId));

        return user.getWishList().stream().map(wish ->
                wishListMapper.getWishListToDto(wish)
        ).toList();

    }


    public ResponseEntity<Void> statusWish(Long wishId, OrderStatus status){

        WishList wish = this.wishListRepository.findById(wishId).orElseThrow(() -> new EntityNotFoundCustomException(wishId));

        wish.setStatus(status);

        this.wishListRepository.save(wish);

        return ResponseEntity.ok().build();


    }


//    public ResponseEntity<Void> updateProfileById(String id, PutProfileRequestDTO body) {
//        Profile profile = profileRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("User not found"));
//
//        profileMapper.updateProfileToEntity(body, profile);
//
//        profileRepository.save(profile);
//
//
//        return ResponseEntity.ok().build();
//
//
//    }


}