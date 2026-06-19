package com.angadiq.ecommerce.repository;

import com.angadiq.ecommerce.entity.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}