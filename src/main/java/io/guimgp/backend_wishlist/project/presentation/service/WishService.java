package io.guimgp.backend_wishlist.project.presentation.service;

import io.guimgp.backend_wishlist.project.domain.dto.wish.CreateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish.GetWishResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish.UpdateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;
import io.guimgp.backend_wishlist.project.domain.mapper.WishMapper;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import io.guimgp.backend_wishlist.project.domain.model.entity.Wish;
import io.guimgp.backend_wishlist.project.domain.model.repository.UserRepository;
import io.guimgp.backend_wishlist.project.domain.model.repository.WishRepository;
import io.guimgp.backend_wishlist.project.infrastructure.exceptions.EntityNotFoundCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WishService {

    @Autowired
    WishMapper wishMapper;

    @Autowired
    WishRepository wishRepository;

    @Autowired
    UserRepository userRepository;


    public ResponseEntity<GetWishResponseDTO> getWishById(String wishId) {

        Wish wish = this.wishRepository.findById(Long.parseLong(wishId)).orElseThrow(() -> new EntityNotFoundCustomException(wishId));

        return ResponseEntity.ok(wishMapper.getWishToDto(wish));
    }

    public ResponseEntity<Void> createWish(String userId, CreateWishRequestDTO body) {

        User user = this.userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new EntityNotFoundCustomException(userId));

        Wish wish = wishMapper.creatWish(body);

        wish.setUser(user);

        wishRepository.save(wish);

        return ResponseEntity.ok().build();


    }

    public List<GetWishResponseDTO> listWishes(String userId) {
        User user = this.userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new EntityNotFoundCustomException(userId));

        return user.getWish().stream().map(wish ->
                wishMapper.getWishToDto(wish)
        ).toList();

    }


    public ResponseEntity<Void> statusWish(Long wishId, OrderStatus status) {

        Wish wish = this.wishRepository.findById(wishId).orElseThrow(() -> new EntityNotFoundCustomException(wishId));

        wish.setStatus(status);

        this.wishRepository.save(wish);

        return ResponseEntity.ok().build();


    }

    public ResponseEntity<Void> updateWishById(Long wishId, UpdateWishRequestDTO body) {
        Wish wish = this.wishRepository.findById(wishId).orElseThrow(() -> new EntityNotFoundCustomException(wishId));

        wishMapper.updateWishFromDto(body, wish);
        wishRepository.save(wish);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


    public ResponseEntity<String> deleteWishById(String id, Long wishId) {

        Wish wish = wishRepository.findById(wishId).orElseThrow(() -> new EntityNotFoundCustomException(wishId));
        if (wish.getUser().getUser_id().equals(UUID.fromString(id))) {
            wishRepository.deleteById(wishId);
            return new ResponseEntity<>("Wish deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);

    }

}