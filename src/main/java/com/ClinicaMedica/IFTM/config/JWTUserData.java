package com.ClinicaMedica.IFTM.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
