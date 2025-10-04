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

import com.ClinicaMedica.IFTM.dto.GuiaDTO;
import com.ClinicaMedica.IFTM.entities.Guia;
import com.ClinicaMedica.IFTM.service.GuiaService;

@RestController
@RequestMapping(value = "/guia")
public class GuiaControle {

	@Autowired
	private GuiaService guiaService;
	
	@GetMapping
	public List<GuiaDTO> findAll(){
		List<GuiaDTO> result = guiaService.findAll();
		return result;
	}
	
	@PostMapping
	public Guia cadastroGuia(@RequestBody Guia cadastroGuia) {
		Guia guiaSalva = guiaService.salvar(cadastroGuia);
		return guiaSalva;
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<Guia> deletarGuia(@PathVariable Long id){
			guiaService.deletarGuia(id);
			
			return ResponseEntity.noContent().build();
		}
	}


