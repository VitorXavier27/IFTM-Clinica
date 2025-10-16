package com.ClinicaMedica.IFTM.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Email e Obrigatorio") String email,
                           @NotEmpty(message = "Senha é Obrigatorio") String password) {
}
