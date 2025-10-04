package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.ExameDTO;
import com.ClinicaMedica.IFTM.entities.Exame;
import com.ClinicaMedica.IFTM.repository.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;
	
	public List<ExameDTO> findAll(){
		List<Exame> result = exameRepository.findAll();
		List<ExameDTO> dto = result.stream().map(x -> new ExameDTO(x)).toList();
		return dto;
	}

	public Exame salvar(Exame exameCadastro) {
		return exameRepository.save(exameCadastro);
	}
	
	public void deletarExame(Long id) {
		if(!exameRepository.existsById(id)) {
			throw new RuntimeException("Exame com ID " + id + " Nao encontrado.Falha na exclusao!");
		}
		exameRepository.deleteById(id);
	}
}
