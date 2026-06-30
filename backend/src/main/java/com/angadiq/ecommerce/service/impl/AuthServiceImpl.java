package com.angadiq.ecommerce.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.angadiq.ecommerce.dto.AuthResponse;
import com.angadiq.ecommerce.dto.LoginRequest;
import com.angadiq.ecommerce.dto.RegisterRequest;
import com.angadiq.ecommerce.entity.RefreshToken;
import com.angadiq.ecommerce.entity.User;
import com.angadiq.ecommerce.repository.UserRepository;
import com.angadiq.ecommerce.security.JwtService;
import com.angadiq.ecommerce.service.AuthService;
import com.angadiq.ecommerce.service.RefreshTokenService;

@Service

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final RefreshTokenService refreshTokenService;

    public AuthServiceImpl(

            UserRepository userRepository,

            PasswordEncoder passwordEncoder,

            JwtService jwtService,

            RefreshTokenService refreshTokenService

    ) {

        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;

        this.jwtService = jwtService;

        this.refreshTokenService = refreshTokenService;

    }

    @Override

    public AuthResponse register(

            RegisterRequest request

    ) {

        if (userRepository.findByEmail(

                request.getEmail()

        ).isPresent()) {

            return new AuthResponse(

                    null,

                    null,

                    "Email already exists"

            );

        }

        User user = new User();

        user.setFullName(

                request.getFullName()

        );

        user.setEmail(

                request.getEmail()

        );

        user.setPassword(

                passwordEncoder.encode(

                        request.getPassword()

                )

        );

        user.setRole(

                "USER"

        );

        userRepository.save(

                user

        );

        String accessToken =

                jwtService.generateToken(

                        user.getEmail()

                );

        RefreshToken refreshToken =

                refreshTokenService.createRefreshToken(

                        user

                );

        return new AuthResponse(

                accessToken,

                refreshToken.getToken(),

                "Registration successful"

        );

    }

    @Override

    public AuthResponse login(

            LoginRequest request

    ) {

        User user = userRepository

                .findByEmail(

                        request.getEmail()

                )

                .orElseThrow(

                        () -> new RuntimeException(

                                "User not found"

                        )

                );

        // DEBUG

        System.out.println(

                "Entered Password : "

                + request.getPassword()

        );

        System.out.println(

                "Database Password : "

                + user.getPassword()

        );

        boolean passwordMatches =

                passwordEncoder.matches(

                        request.getPassword(),

                        user.getPassword()

                );

        System.out.println(

                "Password Match : "

                + passwordMatches

        );

        if (!passwordMatches) {

            throw new RuntimeException(

                    "Invalid password"

            );

        }

        String accessToken =

                jwtService.generateToken(

                        user.getEmail()

                );

        RefreshToken refreshToken =

                refreshTokenService.createRefreshToken(

                        user

                );

        return new AuthResponse(

                accessToken,

                refreshToken.getToken(),

                "Login successful"

        );

    }

}