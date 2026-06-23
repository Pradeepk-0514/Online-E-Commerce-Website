package com.angadiq.ecommerce.service;

import java.util.List;

import com.angadiq.ecommerce.dto.PlaceOrderRequest;
import com.angadiq.ecommerce.entity.Order;

public interface OrderService {

    Order placeOrder(

            PlaceOrderRequest request

    );

    List<Order> getOrders(

            Long userId

    );

}