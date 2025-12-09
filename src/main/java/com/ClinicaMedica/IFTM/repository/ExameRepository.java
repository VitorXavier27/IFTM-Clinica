package com.ClinicaMedica.IFTM.repository;

import com.ClinicaMedica.IFTM.entities.StatusExame;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaMedica.IFTM.entities.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {

    long countByStatus(StatusExame status);
}
