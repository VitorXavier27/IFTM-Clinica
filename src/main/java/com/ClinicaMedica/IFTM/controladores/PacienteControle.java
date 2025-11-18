package com.ClinicaMedica.IFTM.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.ClinicaMedica.IFTM.dto.PacienteDTO;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.service.PacienteService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@CrossOrigin(origins = "http://localhost:5137")
@RequestMapping(value = "/pacientes")
public class PacienteControle {

	@Autowired
	private PacienteService pacienteService;
	
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
    public ResponseEntity<Page<PacienteDTO>> findAll(@PageableDefault(size = 10) Pageable pageable){
        Page<PacienteDTO> dto = pacienteService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping(value = "/{id}")
	public PacienteDTO findById(@PathVariable Long id) {
		PacienteDTO result = pacienteService.findById(id);
		return result;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    public ResponseEntity<PacienteDTO> insert(@RequestBody PacienteDTO dto){
        dto = pacienteService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getIdPaciente()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO>update(@PathVariable Long id, @RequestBody PacienteDTO dto){
        dto = pacienteService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPaciente(@PathVariable  Long id) {
		pacienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @GetMapping("/total")
    public ResponseEntity<Long> getTotalPacientes(){
        long total = pacienteService.contarTotalDePaciente();
        return ResponseEntity.ok(total);
    }
}
