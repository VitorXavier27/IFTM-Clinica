package com.ClinicaMedica.IFTM.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ClinicaMedica.IFTM.dto.LaudoDTO;
import com.ClinicaMedica.IFTM.entities.Laudo;
import com.ClinicaMedica.IFTM.service.LaudoService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin (origins = "http://localhost:5137")
@RequestMapping( value = "/laudo")
public class LaudoControle {

	@Autowired
	private LaudoService laudoService;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<Page<LaudoDTO>> findAll(Pageable pageable){
        Page<LaudoDTO> dto = laudoService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<LaudoDTO> findById(@PathVariable Long id){
        LaudoDTO dto = laudoService.findById(id);
        return ResponseEntity.ok(dto);
    }

	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    public ResponseEntity<LaudoDTO> criarLaudo(@RequestBody LaudoDTO dto){
        dto = laudoService.cadastroLaudo(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId_Laudo()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LaudoDTO> atualizarLaudo(@PathVariable Long id, @RequestBody LaudoDTO dto){
        dto = laudoService.atualizarLaudo(id, dto);
        return ResponseEntity.ok(dto);
    }
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public ResponseEntity<Laudo> deleteById(@PathVariable Long id){
		laudoService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
