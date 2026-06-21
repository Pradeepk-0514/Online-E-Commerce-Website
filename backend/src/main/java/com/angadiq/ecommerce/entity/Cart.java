package com.angadiq.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carts")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")

    private User user;
}