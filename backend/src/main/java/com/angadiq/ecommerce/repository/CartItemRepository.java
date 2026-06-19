package com.angadiq.ecommerce.repository;

import com.angadiq.ecommerce.entity.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}