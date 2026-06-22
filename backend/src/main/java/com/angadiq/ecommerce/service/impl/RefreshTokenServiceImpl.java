package com.angadiq.ecommerce.service.impl;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.angadiq.ecommerce.entity.RefreshToken;
import com.angadiq.ecommerce.entity.User;
import com.angadiq.ecommerce.repository.RefreshTokenRepository;

@Service

public class RefreshTokenServiceImpl {

    @Value("${jwt.refresh.expiration}")

    private long refreshExpiration;

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenServiceImpl(
            RefreshTokenRepository refreshTokenRepository) {

        this.refreshTokenRepository = refreshTokenRepository;

    }

    public RefreshToken createRefreshToken(User user) {

        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(user);

        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken.setExpiryDate(

                Instant.now().plusMillis(refreshExpiration)

        );

        return refreshTokenRepository.save(refreshToken);

    }

}