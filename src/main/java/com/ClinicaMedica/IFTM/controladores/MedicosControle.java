package com.ClinicaMedica.IFTM.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ClinicaMedica.IFTM.dto.MedicosDTO;
import com.ClinicaMedica.IFTM.entities.Medicos;
import com.ClinicaMedica.IFTM.service.MedicosService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin (origins = "http://localhost:5137")
@RequestMapping(value = "/medicos")
public class MedicosControle {

	@Autowired
	private MedicosService medicosService;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<Page<MedicosDTO>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        Page<MedicosDTO>  dto = medicosService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicosDTO> findById(@PathVariable Long id) {
        MedicosDTO dto = medicosService.findById(id);
        return ResponseEntity.ok(dto);
    }
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    public ResponseEntity<MedicosDTO> cadastroMedico(@RequestBody MedicosDTO dto) {
        dto = medicosService.cadastroMedico(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId_Medico()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicosDTO> atualizarMedico(@PathVariable Long id, @RequestBody MedicosDTO dto) {
        dto = medicosService.atualizarMedico(id, dto);
        return ResponseEntity.ok(dto);
    }
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarMedico(@PathVariable Long id){
		medicosService.deletarMedico(id);
		return ResponseEntity.noContent().build();
	}
}
