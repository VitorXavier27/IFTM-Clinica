package com.ClinicaMedica.IFTM.repository;

import com.ClinicaMedica.IFTM.entities.StatusExame;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ClinicaMedica.IFTM.entities.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {


}
