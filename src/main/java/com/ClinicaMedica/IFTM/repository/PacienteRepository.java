package com.ClinicaMedica.IFTM.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaMedica.IFTM.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	Optional<Paciente> findById(Long id);
}
