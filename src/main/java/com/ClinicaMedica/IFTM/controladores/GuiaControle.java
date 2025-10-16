package com.ClinicaMedica.IFTM.controladores;

import java.time.Instant;
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

import com.ClinicaMedica.IFTM.dto.GuiaDTO;
import com.ClinicaMedica.IFTM.entities.Guia;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.repository.GuiaRepository;
import com.ClinicaMedica.IFTM.repository.PacienteRepository;
import com.ClinicaMedica.IFTM.service.GuiaService;

@RestController
@CrossOrigin (origins = "http://localhost:5137")
@RequestMapping(value = "/guia")
public class GuiaControle {

	@Autowired
	private GuiaService guiaService;
	
	@Autowired
	private GuiaRepository guiaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
	public List<GuiaDTO> findAll(){
		List<GuiaDTO> result = guiaService.findAll();
		return result;
	}
	
	/*@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
	public Guia cadastroGuia(@RequestBody Guia cadastroGuia) {
		Guia guiaSalva = guiaService.salvar(cadastroGuia);
		return guiaSalva;
	}*/
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<?> criarGuia(@RequestBody GuiaDTO guiaDTO){
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(guiaDTO.getPacienteId());
		
		if(!pacienteOptional.isPresent()){
			return ResponseEntity.badRequest().body("Pacientecom ID " + guiaDTO.getPacienteId()+" Nao Encontrado");
		}
		
		Paciente pacienteEncontrado = pacienteOptional.get();
		
		Guia novoGuia = new Guia();
		novoGuia.setConvenio_Guia(guiaDTO.getConvenio_Guia());
		novoGuia.setData_Emissao_Guia(Instant.now());
		novoGuia.setNumero_Guia(guiaDTO.getNumero_Guia());
		
		novoGuia.setPaciente(pacienteEncontrado);
		
		Guia guiasSalvas = guiaRepository.save(novoGuia);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(guiasSalvas);
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
		public ResponseEntity<Guia> deletarGuia(@PathVariable Long id){
			guiaService.deletarGuia(id);
			
			return ResponseEntity.noContent().build();
		}
	}


