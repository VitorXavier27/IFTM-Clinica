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

import com.ClinicaMedica.IFTM.dto.LaudoDTO;
import com.ClinicaMedica.IFTM.entities.Laudo;
import com.ClinicaMedica.IFTM.service.LaudoService;

@RestController
@RequestMapping( value = "/laudo")
public class LaudoControle {

	@Autowired
	private LaudoService laudoService;
	
	@GetMapping
	public List<LaudoDTO> findAll(){
		List<LaudoDTO> result = laudoService.findAll();
		return result;
	}
	
	@PostMapping
		public Laudo cadastroLaudo(@RequestBody Laudo cadastroLaudo) {
		Laudo laudoSalvo = laudoService.save(cadastroLaudo);
		return laudoSalvo;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Laudo> deleteById(@PathVariable Long id){
		laudoService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
