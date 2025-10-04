package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.MedicosDTO;
import com.ClinicaMedica.IFTM.entities.Medicos;
import com.ClinicaMedica.IFTM.repository.MedicosRepository;

@Service
public class MedicosService {

	@Autowired
	private MedicosRepository medicosRepository;
	
	public List<MedicosDTO> findAll(){
		List<Medicos> result = medicosRepository.findAll();
		List<MedicosDTO> dto = result.stream().map(x -> new MedicosDTO(x)).toList();
		return dto;
	}
	
	public Medicos salvar(Medicos cadastroMedicos) {
		return medicosRepository.save(cadastroMedicos);
	}
	
	public void deletarPorId(Long id) {
		
		if(!medicosRepository.existsById(id)) {
			throw new RuntimeException("Medico com ID " + id + " não encontrado,falha na exclusao");
		}
			medicosRepository.deleteById(id);
	}
}
