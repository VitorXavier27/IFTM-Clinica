package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.TipoAnaliseDTO;
import com.ClinicaMedica.IFTM.entities.TipoAnalise;
import com.ClinicaMedica.IFTM.repository.TipoAnaliseRepository;

@Service
public class TipoAnaliseService {

	@Autowired
	private TipoAnaliseRepository tipoAnaliseRepository;
	
	public List<TipoAnaliseDTO> findAll(){
		List<TipoAnalise> result = tipoAnaliseRepository.findAll();
		List<TipoAnaliseDTO> dto = result.stream().map(x -> new TipoAnaliseDTO(x)).toList();
		return dto;
	}
	
	public TipoAnalise save(TipoAnalise cadastroTipoAnalise) {
		return tipoAnaliseRepository.save(cadastroTipoAnalise);
	}
	
	public void deleteById(Long id) {
		
		if(!tipoAnaliseRepository.existsById(id)) {
			throw new RuntimeException("Analise Não Encontrada " + id + " falha na exclusao!");
		}
			tipoAnaliseRepository.deleteById(id);
	}
}
