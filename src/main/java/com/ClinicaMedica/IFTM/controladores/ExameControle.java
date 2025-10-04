package com.ClinicaMedica.IFTM.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaMedica.IFTM.dto.ExameDTO;
import com.ClinicaMedica.IFTM.entities.Exame;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.repository.ExameRepository;
import com.ClinicaMedica.IFTM.repository.PacienteRepository;
import com.ClinicaMedica.IFTM.service.ExameService;

@RestController
@CrossOrigin(origins = "http://localhost:5137")
@RequestMapping(value = "/exame")
public class ExameControle {

	@Autowired
	private ExameService exameService;
	
	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
	public List<ExameDTO> findAll(){
		List<ExameDTO> result = exameService.findAll();
		return result;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
	public Exame cadastroExame(@RequestBody Exame cadastroExame) {
		Exame exameSalvo = exameService.salvar(cadastroExame);
		return exameSalvo;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping("/Exams")
	public ResponseEntity<?> criarExame(@RequestBody ExameDTO exameDTO){
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(exameDTO.getPacienteId());
		
		if(!pacienteOptional.isPresent()) {
			return ResponseEntity.badRequest().body("Paciente com ID" + exameDTO.getPacienteId()+"Nao Encontrado");
		}
		
		Paciente pacienteEncontrado = pacienteOptional.get();
		
		Exame novoExame = new Exame();
		novoExame.setTipo_Exame(exameDTO.getTipo_Exame());
		novoExame.setResultado_Exame(exameDTO.getResultado_Exame());
		novoExame.setData_Exame(exameDTO.getData_Exame());
		
		novoExame.setPaciente(pacienteEncontrado);
		
		Exame exameSalvos = exameRepository.save(novoExame);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(exameSalvos);
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
		public ResponseEntity<Exame> deletarExame(@PathVariable Long id){
			exameService.deletarExame(id);
			
			return ResponseEntity.noContent().build();
	}
}
