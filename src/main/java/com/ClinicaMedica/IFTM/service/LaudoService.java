package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.LaudoDTO;
import com.ClinicaMedica.IFTM.entities.Laudo;
import com.ClinicaMedica.IFTM.repository.LaudoRepository;

@Service
public class LaudoService {

	@Autowired
	private LaudoRepository laudoRepository;
	
	public List<LaudoDTO> findAll(){
		List<Laudo> result = laudoRepository.findAll();
		List<LaudoDTO> dto = result.stream().map(x -> new LaudoDTO(x)).toList();
		return dto;
	}
	
	public Laudo save(Laudo cadastrarLaudo) {
		return laudoRepository.save(cadastrarLaudo);
	}
	
	public void deleteById(Long id) {
		
		if(!laudoRepository.existsById(id)) {
			throw new RuntimeException("Laudo ID: " + id + " Não encontrado,Falha na exclusao");
		}
			laudoRepository.deleteById(id);
	}
}
