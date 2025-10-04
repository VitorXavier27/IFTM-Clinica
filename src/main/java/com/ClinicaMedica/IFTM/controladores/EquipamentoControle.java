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

import com.ClinicaMedica.IFTM.dto.EquipamentoDTO;
import com.ClinicaMedica.IFTM.entities.Equipamento;
import com.ClinicaMedica.IFTM.service.EquipamentoService;

@RestController
@RequestMapping(value = "/equipamento")
public class EquipamentoControle {

	@Autowired
	private EquipamentoService equipamentoService;
	
	@GetMapping
	public List<EquipamentoDTO> findAll(){
		List<EquipamentoDTO> result = equipamentoService.findAll();
		return result;
	}
	
	@PostMapping
	public Equipamento cadastroEquipamento(@RequestBody Equipamento cadastroEquipamento) {
		Equipamento equipamentoSalvo = equipamentoService.save(cadastroEquipamento);
		return equipamentoSalvo;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Equipamento> deletarEquipamento(@PathVariable Long id){
		equipamentoService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
