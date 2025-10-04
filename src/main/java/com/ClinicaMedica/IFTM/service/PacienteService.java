package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClinicaMedica.IFTM.dto.PacienteDTO;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public List<PacienteDTO> findAll(){
		List<Paciente> result = pacienteRepository.findAll();
		List<PacienteDTO> dto = result.stream().map(x -> new PacienteDTO(x)).toList();
		return dto;
	}
	

	@Transactional(readOnly = true)
		public PacienteDTO findById(Long id) {
			Paciente result = pacienteRepository.findById(id).get();
			return new PacienteDTO(result);
	}
	
	public Paciente salvar(Paciente pacienteParaCadastrar) {
		return pacienteRepository.save(pacienteParaCadastrar);
	}

	public void  deletarPorId(Long  id) {
		
		if (!pacienteRepository.existsById(id)) {
			throw new RuntimeException("Paciente com ID " + id + " não encontrado, falha na exclusao");
		}
		  pacienteRepository.deleteById(id);
	}
}
