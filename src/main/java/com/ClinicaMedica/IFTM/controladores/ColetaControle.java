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

import com.ClinicaMedica.IFTM.dto.ColetaDTO;
import com.ClinicaMedica.IFTM.entities.Coleta;
import com.ClinicaMedica.IFTM.service.ColetaService;

@RestController
@RequestMapping(value = "/coleta")
public class ColetaControle {

	
	@Autowired
	private ColetaService coletaService;
	
	@GetMapping
	public List<ColetaDTO> findAll(){
		List<ColetaDTO> result = coletaService.findAll();
		return result;
	}
	
	@PostMapping
	public Coleta cadastroColeta(@RequestBody Coleta cadastroColeta) {
		Coleta coletaSalva = coletaService.save(cadastroColeta);
		return coletaSalva;
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<Coleta> deletarColeta(@PathVariable Long id){
			coletaService.deleteById(id);
			
			return ResponseEntity.noContent().build();
	}
}
