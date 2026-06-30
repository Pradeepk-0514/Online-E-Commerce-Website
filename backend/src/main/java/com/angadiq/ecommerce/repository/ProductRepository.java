package com.angadiq.ecommerce.repository;

import com.angadiq.ecommerce.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}