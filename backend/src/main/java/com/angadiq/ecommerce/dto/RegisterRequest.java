package com.angadiq.ecommerce.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RegisterRequest {

    private String fullName;

    private String email;

    private String password;

}