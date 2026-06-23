package com.angadiq.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartResponse {

    private Long productId;

    private String productName;

    private Double price;

    private Integer quantity;

    private Double subtotal;

}