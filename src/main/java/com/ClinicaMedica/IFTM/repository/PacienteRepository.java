package com.ClinicaMedica.IFTM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaMedica.IFTM.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
