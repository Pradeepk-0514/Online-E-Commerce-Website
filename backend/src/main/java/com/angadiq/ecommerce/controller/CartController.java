package com.angadiq.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.angadiq.ecommerce.dto.AddToCartRequest;
import com.angadiq.ecommerce.dto.CartResponse;
import com.angadiq.ecommerce.entity.CartItem;
import com.angadiq.ecommerce.service.CartService;

@RestController

@RequestMapping("/api/cart")

public class CartController {

    private final CartService cartService;

    public CartController(

            CartService cartService

    ) {

        this.cartService = cartService;

    }

    @PostMapping

    public ResponseEntity<CartItem>

    addToCart(

            @RequestBody AddToCartRequest request

    ) {

        return ResponseEntity.ok(

                cartService.addToCart(

                        request

                )

        );

    }

    @GetMapping("/{userId}")

    public ResponseEntity<List<CartItem>>

    getCart(

            @PathVariable Long userId

    ) {

        return ResponseEntity.ok(

                cartService.getCartItems(

                        userId

                )

        );

    }

    @GetMapping("/response/{userId}")

    public ResponseEntity<List<CartResponse>>

    getCartResponse(

            @PathVariable Long userId

    ) {

        return ResponseEntity.ok(

                cartService.getCartResponse(

                        userId

                )

        );

    }

}