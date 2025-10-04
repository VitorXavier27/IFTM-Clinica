package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.GuiaDTO;
import com.ClinicaMedica.IFTM.entities.Guia;
import com.ClinicaMedica.IFTM.repository.GuiaRepository;

@Service
public class GuiaService {

	
	@Autowired
	private GuiaRepository guiaRepository;
	
	public List<GuiaDTO> findAll(){
		List<Guia> result = guiaRepository.findAll();
		List<GuiaDTO> dto = result.stream().map(x -> new GuiaDTO(x)).toList();
		return dto;
	}
	
	public Guia salvar(Guia cadastroGuia) {
		return guiaRepository.save(cadastroGuia);
	}
	
	public void deletarGuia(Long id) {
		
		if(!guiaRepository.existsById(id)) {
			throw new RuntimeException("Guia com ID " + id + "Guia nao encontrada,falha na exclusão");
		}
		guiaRepository.deleteById(id);
	}
}
