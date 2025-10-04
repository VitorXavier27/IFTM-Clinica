package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.EquipamentoDTO;
import com.ClinicaMedica.IFTM.entities.Equipamento;
import com.ClinicaMedica.IFTM.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	public List<EquipamentoDTO> findAll(){
		List<Equipamento> result = equipamentoRepository.findAll();
		List<EquipamentoDTO> dto = result.stream().map(x -> new EquipamentoDTO(x)).toList();
		return dto;
	}
	
	public Equipamento save(Equipamento equipamentoSalvar) {
		return equipamentoRepository.save(equipamentoSalvar);
	}
	
	public void deleteById(Long id) {
		
		if(!equipamentoRepository.existsById(id)) {
			throw new RuntimeException("Id do Equipamento: " + id + " Nao encontrado,Falha na exclusao");
		}
		equipamentoRepository.deleteById(id);
	}
}
