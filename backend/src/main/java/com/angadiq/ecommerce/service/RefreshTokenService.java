package com.angadiq.ecommerce.service;

import com.angadiq.ecommerce.entity.RefreshToken;
import com.angadiq.ecommerce.entity.User;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(User user);

    RefreshToken verifyRefreshToken(String token);

    void deleteByUser(User user);

}