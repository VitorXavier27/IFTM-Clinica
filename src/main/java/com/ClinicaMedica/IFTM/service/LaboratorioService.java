package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.LaboratorioDTO;
import com.ClinicaMedica.IFTM.entities.Laboratorio;
import com.ClinicaMedica.IFTM.repository.LaboratorioRepository;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
	public List<LaboratorioDTO> findAll(){
		List<Laboratorio> result = laboratorioRepository.findAll();
		List<LaboratorioDTO> dto = result.stream().map(x -> new LaboratorioDTO(x)).toList();
		return dto;
	}
	
	public Laboratorio save(Laboratorio cadastroLaboratorio) {
		return laboratorioRepository.save(cadastroLaboratorio);
	}
	
	public void deleteById(Long id) {
		
		if(!laboratorioRepository.existsById(id)) {
			throw new RuntimeException("Id Laboratorio: " + id + " Nao Encontrado. Falha na exclusao");
		}
		
		laboratorioRepository.deleteById(id);
	}
}
