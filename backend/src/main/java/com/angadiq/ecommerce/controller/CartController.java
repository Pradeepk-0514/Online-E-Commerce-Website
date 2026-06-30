package com.angadiq.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        String email =

                SecurityContextHolder

                        .getContext()

                        .getAuthentication()

                        .getName();

        return ResponseEntity.ok(

                cartService.addToCart(

                        email,

                        request

                )

        );

    }

    @GetMapping("/me")

    public ResponseEntity<List<CartResponse>>

    getMyCart() {

        String email =

                SecurityContextHolder

                        .getContext()

                        .getAuthentication()

                        .getName();

        return ResponseEntity.ok(

                cartService.getCartResponse(

                        email

                )

        );

    }

}