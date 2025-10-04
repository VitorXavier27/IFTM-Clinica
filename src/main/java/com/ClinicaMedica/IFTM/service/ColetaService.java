package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.ColetaDTO;
import com.ClinicaMedica.IFTM.entities.Coleta;
import com.ClinicaMedica.IFTM.repository.ColetaRepository;

@Service
public class ColetaService {


	
	@Autowired
	private ColetaRepository coletaRepository;

 
	
	public List<ColetaDTO> findAll(){
		List<Coleta> result = coletaRepository.findAll();
		List<ColetaDTO> dto = result.stream().map(x -> new ColetaDTO(x)).toList();
		return dto;
	}
	
	public Coleta save(Coleta cadastroDeColeta) {
		return coletaRepository.save(cadastroDeColeta);
	}
	
	public void deleteById(Long id) {
		
		if(!coletaRepository.existsById(id)) {
			throw new RuntimeException("Coleta com ID: " + id + " Nao foi encontrado,falha na exclusao.");
		}
		coletaRepository.deleteById(id);
	}
}
