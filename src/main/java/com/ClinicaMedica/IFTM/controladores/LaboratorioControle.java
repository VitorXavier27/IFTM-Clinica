package com.ClinicaMedica.IFTM.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ClinicaMedica.IFTM.dto.LaboratorioDTO;
import com.ClinicaMedica.IFTM.entities.Laboratorio;
import com.ClinicaMedica.IFTM.service.LaboratorioService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/laboratorio")
public class LaboratorioControle {

	@Autowired
	private LaboratorioService laboratorioService;
	
	@GetMapping
	public ResponseEntity<Page<LaboratorioDTO>> findAll(@PageableDefault(size = 10) Pageable pageable){
        Page<LaboratorioDTO> dto = laboratorioService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public LaboratorioDTO findById(@PathVariable Long id){
        LaboratorioDTO dto = laboratorioService.findById(id);
        return dto;
    }
	
	@PostMapping
    public ResponseEntity<LaboratorioDTO> salvarLaboratorio(@RequestBody LaboratorioDTO dto){
        dto = laboratorioService.cadastrarLaboratorio(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId_Laboratorio()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LaboratorioDTO> atualizarLaboratorio(@PathVariable Long id, @RequestBody LaboratorioDTO dto){
        dto = laboratorioService.atualizarLaboratorio(id, dto);
        return ResponseEntity.ok(dto);
    }
	
	@DeleteMapping("/{id}")
		public ResponseEntity<Laboratorio> deletarLaboratorio(@PathVariable Long id){
			laboratorioService.deleteById(id);
			
			return ResponseEntity.noContent().build();
	}
}
