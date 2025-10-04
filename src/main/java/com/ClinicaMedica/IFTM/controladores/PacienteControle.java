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

import com.ClinicaMedica.IFTM.dto.PacienteDTO;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.service.PacienteService;


@RestController
@CrossOrigin(origins = "http://localhost:5137")
@RequestMapping(value = "/pacientes")
public class PacienteControle {

	@Autowired
	private PacienteService pacienteService;
	
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
	public List<PacienteDTO> findAll(){
		List<PacienteDTO> result = pacienteService.findAll();
		return result;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping(value = "/{id}")
	public PacienteDTO findById(@PathVariable Long id) {
		PacienteDTO result = pacienteService.findById(id);
		return result;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
	public Paciente cadastroPaciente(@RequestBody Paciente pacienteParaCadastrar) {
		Paciente pacienteSalvo = pacienteService.salvar(pacienteParaCadastrar);
		return pacienteSalvo;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> deletarPaciente(@PathVariable  Long id) {
		pacienteService.deletarPorId(id);
		
		return ResponseEntity.noContent().build();
	}
}
