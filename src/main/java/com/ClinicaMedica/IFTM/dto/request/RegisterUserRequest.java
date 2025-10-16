package com.ClinicaMedica.IFTM.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Nome e Obrigatorio") String name,
                                  @NotEmpty(message = "E-mail e Obrigatorio") String email,
                                  @NotEmpty(message = "Senha e Obrigatorio") String password){
}
