package io.guimgp.backend_wishlist.project.presentation.controller;


import io.guimgp.backend_wishlist.project.domain.dto.wish_list.CreateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish_list.GetWishListResponseDTO;
import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;
import io.guimgp.backend_wishlist.project.presentation.service.WishListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{userId}/wishlist")
@RequiredArgsConstructor
public class WishListController {

    @Autowired
    WishListService wishListService;

    @GetMapping("/{wishId}")
    public ResponseEntity<GetWishListResponseDTO> getWishById(@PathVariable("wishId") String wishId) {
        return wishListService.getWishById(wishId);

    }

    @PostMapping("/create")
    public ResponseEntity<Void> createWish(@PathVariable("userId") String userId,
                                           @Valid @RequestBody CreateWishRequestDTO body) {

        return wishListService.createWish(userId, body);

    }

    @GetMapping("/list")
    public ResponseEntity<List<GetWishListResponseDTO>> listWishes(@PathVariable("userId") String userId) {

        return ResponseEntity.ok(wishListService.listWishes(userId));

    }

    @PostMapping("/status/{wishId}")
    public ResponseEntity<Void> statusWish(@PathVariable("wishId") String wishId, @RequestParam OrderStatus status) {


        return wishListService.statusWish(Long.parseLong(wishId), status);

    }


//    @PutMapping("/{userId}")
//    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId,
//                                               @RequestBody PutUserRequestDTO body) {
//        return userService.updateUserById(userId, body);
//    }
//
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") String userId, HttpServletRequest request) {
//        return userService.deleteUserById(userId, request);
//    }

}
