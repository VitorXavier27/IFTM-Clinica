package com.ClinicaMedica.IFTM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaMedica.IFTM.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	Optional<Paciente> findById(Long id);
}
