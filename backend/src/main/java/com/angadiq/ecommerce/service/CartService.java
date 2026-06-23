package com.angadiq.ecommerce.service;

import java.util.List;

import com.angadiq.ecommerce.dto.AddToCartRequest;
import com.angadiq.ecommerce.dto.CartResponse;
import com.angadiq.ecommerce.entity.CartItem;

public interface CartService {

    CartItem addToCart(

            AddToCartRequest request

    );

    List<CartItem> getCartItems(

            Long userId

    );

    List<CartResponse> getCartResponse(

            Long userId

    );

}