package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.AmostraDTO;
import com.ClinicaMedica.IFTM.entities.Amostra;
import com.ClinicaMedica.IFTM.repository.AmostraRepository;

@Service
public class AmostraService {

	@Autowired
	private AmostraRepository amostraRepository;
	
	public List<AmostraDTO> findAll(){
		List<Amostra> result = amostraRepository.findAll();
		List<AmostraDTO> dto = result.stream().map(x -> new AmostraDTO(x)).toList();
		return dto;
	}
	
	public Amostra salvar(Amostra amostraCadastro) {
		return amostraRepository.save(amostraCadastro);
	}
	
	public void deletarExame(Long id) {
		
		if(!amostraRepository.existsById(id)) {
			throw new RuntimeException("Amostra com ID " + id + " amostra nao encontrada,falha na exclusao!");
		}
			amostraRepository.deleteById(id);
	}
}
