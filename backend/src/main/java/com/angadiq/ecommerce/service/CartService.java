package com.angadiq.ecommerce.service;

import java.util.List;

import com.angadiq.ecommerce.dto.AddToCartRequest;
import com.angadiq.ecommerce.dto.CartResponse;
import com.angadiq.ecommerce.entity.CartItem;

public interface CartService {

    CartItem addToCart(

            String email,

            AddToCartRequest request

    );

    List<CartResponse> getCartResponse(

            String email

    );

}