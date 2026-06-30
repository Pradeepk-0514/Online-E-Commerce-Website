package com.angadiq.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angadiq.ecommerce.entity.Order;
import com.angadiq.ecommerce.entity.OrderItem;

public interface OrderItemRepository
        extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrder(

            Order order

    );

}