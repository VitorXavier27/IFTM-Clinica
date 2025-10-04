package com.ClinicaMedica.IFTM.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaMedica.IFTM.dto.LaboratorioDTO;
import com.ClinicaMedica.IFTM.entities.Laboratorio;
import com.ClinicaMedica.IFTM.service.LaboratorioService;

@RestController
@RequestMapping(value = "/laboratorio")
public class LaboratorioControle {

	@Autowired
	private LaboratorioService laboratorioService;
	
	@GetMapping
	public List<LaboratorioDTO> findAll(){
		List<LaboratorioDTO> result = laboratorioService.findAll();
		return result;
	}
	
	@PostMapping
	public Laboratorio cadastroLaboratorio(@RequestBody Laboratorio cadastroLaboratorio) {
		Laboratorio laboratorioSalvo = laboratorioService.save(cadastroLaboratorio);
		return laboratorioSalvo;
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<Laboratorio> deletarLaboratorio(@PathVariable Long id){
			laboratorioService.deleteById(id);
			
			return ResponseEntity.noContent().build();
	}
}
