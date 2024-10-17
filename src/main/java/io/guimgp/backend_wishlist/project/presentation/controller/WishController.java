package io.guimgp.backend_wishlist.project.presentation.controller;


import io.guimgp.backend_wishlist.project.domain.dto.wish.CreateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish.GetWishResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish.UpdateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.enums.OrderStatus;
import io.guimgp.backend_wishlist.project.presentation.service.WishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/wish")
@RequiredArgsConstructor
public class WishController {

    @Autowired
    WishService wishService;

    @GetMapping("/{wishId}")
    public ResponseEntity<GetWishResponseDTO> getWishById(@RequestParam("userId") String userId, @PathVariable("wishId") String wishId) {
        return wishService.getWishById(wishId);

    }

    @PostMapping("/create")
    public ResponseEntity<Void> createWish(@RequestParam("userId") String userId,
                                           @Valid @RequestBody CreateWishRequestDTO body) {

        return wishService.createWish(userId, body);

    }

    @GetMapping("/list")
    public ResponseEntity<List<GetWishResponseDTO>> listWishes(@RequestParam("userId") String userId) {

        return ResponseEntity.ok(wishService.listWishes(userId));

    }

    @PostMapping("/status/{wishId}")
    public ResponseEntity<Void> statusWish(@RequestParam("userId") String userId,
                                           @PathVariable("wishId") String wishId, @RequestParam OrderStatus status) {


        return wishService.statusWish(Long.parseLong(wishId), status);

    }


    @PutMapping("/{wishId}")
    public ResponseEntity<Void> updateWishById(@RequestParam("userId") String userId,
                                               @PathVariable("wishId") Long wishId,
                                               @Valid @RequestBody UpdateWishRequestDTO body) {
        return wishService.updateWishById(wishId, body);
    }

    @DeleteMapping("/{wishId}")
    public ResponseEntity<String> deleteWishById(@RequestParam("userId") String userId,
                                                 @PathVariable("wishId") Long wishId
    ) {
        return wishService.deleteWishById(userId, wishId);
    }


}
