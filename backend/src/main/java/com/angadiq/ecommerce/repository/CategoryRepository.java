package com.angadiq.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angadiq.ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
