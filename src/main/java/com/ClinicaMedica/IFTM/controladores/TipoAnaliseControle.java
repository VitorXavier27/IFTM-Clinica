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

import com.ClinicaMedica.IFTM.dto.TipoAnaliseDTO;
import com.ClinicaMedica.IFTM.entities.TipoAnalise;
import com.ClinicaMedica.IFTM.service.TipoAnaliseService;

@RestController
@RequestMapping(value = "/tipoAnalise")
public class TipoAnaliseControle {

	@Autowired
	private TipoAnaliseService tipoAnaliseService;
	
	@GetMapping
	public List<TipoAnaliseDTO> findAll(){
		List<TipoAnaliseDTO> result = tipoAnaliseService.findAll();
		return result;
	}
	
	@PostMapping
	public TipoAnalise cadastroTipoAnalise(@RequestBody TipoAnalise cadastroTipoAnalise) {
		TipoAnalise tipoAnaliseSalvo = tipoAnaliseService.save(cadastroTipoAnalise);
		return tipoAnaliseSalvo;
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<TipoAnalise> deletarTipoAnalise(@PathVariable Long id){
			tipoAnaliseService.deleteById(id);
			
			return ResponseEntity.noContent().build();
	}
}
