package com.angadiq.ecommerce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angadiq.ecommerce.dto.AddToCartRequest;
import com.angadiq.ecommerce.dto.CartResponse;
import com.angadiq.ecommerce.entity.Cart;
import com.angadiq.ecommerce.entity.CartItem;
import com.angadiq.ecommerce.entity.Product;
import com.angadiq.ecommerce.entity.User;
import com.angadiq.ecommerce.repository.CartItemRepository;
import com.angadiq.ecommerce.repository.CartRepository;
import com.angadiq.ecommerce.repository.ProductRepository;
import com.angadiq.ecommerce.repository.UserRepository;
import com.angadiq.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(
            CartRepository cartRepository,
            CartItemRepository cartItemRepository,
            UserRepository userRepository,
            ProductRepository productRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartItem addToCart(
            String email,
            AddToCartRequest request) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository
                .findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = cartRepository
                .findByUserId(user.getId())
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        CartItem cartItem = cartItemRepository
                .findByCartAndProduct(cart, product)
                .orElseGet(() -> {
                    CartItem item = new CartItem();
                    item.setCart(cart);
                    item.setProduct(product);
                    item.setQuantity(0);
                    return item;
                });

        cartItem.setQuantity(
                cartItem.getQuantity() + request.getQuantity());

        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartResponse> getCartResponse(
            String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = cartRepository
                .findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        return cartItemRepository
                .findByCart(cart)
                .stream()
                .map(item -> new CartResponse(
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getQuantity(),
                        item.getProduct().getPrice() * item.getQuantity()
                ))
                .toList();
    }
}