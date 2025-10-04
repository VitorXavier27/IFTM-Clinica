package com.ClinicaMedica.IFTM.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaMedica.IFTM.dto.MedicosDTO;
import com.ClinicaMedica.IFTM.entities.Medicos;
import com.ClinicaMedica.IFTM.service.MedicosService;

@RestController
@CrossOrigin (origins = "http://localhost:5137")
@RequestMapping(value = "/medicos")
public class MedicosControle {

	@Autowired
	private MedicosService medicosService;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
	public List<MedicosDTO> findAll(){
		List<MedicosDTO> result = medicosService.findAll();
		return result;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
	public Medicos cadastroMedicos(@RequestBody Medicos cadastroMedicos) {
		Medicos medicoCadastrado = medicosService.salvar(cadastroMedicos);
		return medicoCadastrado;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public ResponseEntity<Medicos> deletarMedico(@PathVariable Long id){
		medicosService.deletarPorId(id);
		
		return ResponseEntity.noContent().build();
	}
}
