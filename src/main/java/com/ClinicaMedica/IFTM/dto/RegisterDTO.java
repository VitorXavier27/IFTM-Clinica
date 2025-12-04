package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role){
}
