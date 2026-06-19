package com.angadiq.ecommerce.repository;

import com.angadiq.ecommerce.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}