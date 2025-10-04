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

import com.ClinicaMedica.IFTM.dto.AmostraDTO;
import com.ClinicaMedica.IFTM.entities.Amostra;
import com.ClinicaMedica.IFTM.service.AmostraService;

@RestController
@RequestMapping(value = "/amostra")
public class AmostraControle {

	@Autowired
	private AmostraService amostraService;
	
	@GetMapping
	public List<AmostraDTO> findAll(){
		List<AmostraDTO> result = amostraService.findAll();
		return result;
	}
	
	@PostMapping
	public Amostra CadastroAmostra(@RequestBody Amostra cadastroAmostra) {
		Amostra amostraSalva = amostraService.salvar(cadastroAmostra);
		return amostraSalva;
	}
	
	@DeleteMapping("/{id}")
		public ResponseEntity<Amostra> deletarAmostra(@PathVariable Long id){
			amostraService.deletarExame(id);
			
			return ResponseEntity.noContent().build();
	}
}
