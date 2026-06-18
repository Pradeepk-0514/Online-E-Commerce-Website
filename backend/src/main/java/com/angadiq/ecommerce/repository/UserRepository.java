package com.angadiq.ecommerce.repository;

import com.angadiq.ecommerce.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}