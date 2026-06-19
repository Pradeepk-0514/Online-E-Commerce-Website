package com.angadiq.ecommerce.repository;

import com.angadiq.ecommerce.entity.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}