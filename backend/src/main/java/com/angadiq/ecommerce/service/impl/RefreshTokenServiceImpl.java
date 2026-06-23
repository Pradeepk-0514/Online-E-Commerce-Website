package com.angadiq.ecommerce.service.impl;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.angadiq.ecommerce.entity.RefreshToken;
import com.angadiq.ecommerce.entity.User;
import com.angadiq.ecommerce.repository.RefreshTokenRepository;
import com.angadiq.ecommerce.service.RefreshTokenService;

@Service

public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Value("${jwt.refresh.expiration}")

    private long refreshExpiration;

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenServiceImpl(

            RefreshTokenRepository refreshTokenRepository

    ) {

        this.refreshTokenRepository = refreshTokenRepository;

    }

    @Override

    public RefreshToken createRefreshToken(

            User user

    ) {

        RefreshToken refreshToken =

                new RefreshToken();

        refreshToken.setUser(

                user

        );

        refreshToken.setToken(

                UUID.randomUUID()

                        .toString()

        );

        refreshToken.setExpiryDate(

                Instant.now()

                        .plusMillis(

                                refreshExpiration

                        )

        );

        return refreshTokenRepository.save(

                refreshToken

        );

    }

    @Override

    public RefreshToken verifyRefreshToken(

            String token

    ) {

        RefreshToken refreshToken =

                refreshTokenRepository

                        .findByToken(

                                token

                        )

                        .orElseThrow(

                                () -> new RuntimeException(

                                        "Refresh token not found"

                                )

                        );

        if (

                refreshToken

                        .getExpiryDate()

                        .isBefore(

                                Instant.now()

                        )

        ) {

            refreshTokenRepository.delete(

                    refreshToken

            );

            throw new RuntimeException(

                    "Refresh token expired"

            );

        }

        return refreshToken;

    }

    @Override

    public void deleteByUser(

            User user

    ) {

        refreshTokenRepository

                .deleteByUser(

                        user

                );

    }

}