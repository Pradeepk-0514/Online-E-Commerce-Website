package com.angadiq.ecommerce.service;

import com.angadiq.ecommerce.dto.AuthResponse;
import com.angadiq.ecommerce.dto.LoginRequest;
import com.angadiq.ecommerce.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}