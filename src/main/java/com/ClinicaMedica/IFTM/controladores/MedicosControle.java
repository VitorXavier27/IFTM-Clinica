package com.ClinicaMedica.IFTM.controladores;

import java.net.URI;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Medicos" , description = "Controlador para salvar e editar dados dos Medicos!")
public class MedicosControle {

	@Autowired
	private MedicosService medicosService;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
    @Operation(summary = "Busca os Medicos salvos paginados em 10", description = "Metodo para buscar todos os Medicos")
    @ApiResponse(responseCode = "200" , description = "Medicos Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<Page<MedicosDTO>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        Page<MedicosDTO>  dto = medicosService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    @Operation (summary = "Busca os Medico por ID", description = "Metodo para buscar Medico por ID")
    @ApiResponse(responseCode = "200" , description = "Medico Buscado com sucesso")
    @ApiResponse(responseCode = "404", description = "Medico Não Cadastrado ou nao Encontrado")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<MedicosDTO> findById(@PathVariable Long id) {
        MedicosDTO dto = medicosService.findById(id);
        return ResponseEntity.ok(dto);
    }
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    @Operation (summary = "Fazer o Cadastro dos Medicos", description = "Metodo para Cadastrar Medicos")
    @ApiResponse(responseCode = "201" , description = "Medico Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<MedicosDTO> cadastroMedico(@RequestBody MedicosDTO dto) {
        dto = medicosService.cadastroMedico(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId_Medico()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @Operation (summary = "Atualiza Dados dos Medicos", description = "Metodo para Atualizar Medicos")
    @ApiResponse(responseCode = "200" , description = "Medico Atualizado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Medico Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<MedicosDTO> atualizarMedico(@PathVariable Long id, @RequestBody MedicosDTO dto) {
        dto = medicosService.atualizarMedico(id, dto);
        return ResponseEntity.ok(dto);
    }
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Medicos", description = "Metodo para Deletar Medicos")
    @ApiResponse(responseCode = "204" , description = "Medico Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Medico Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<Void> deletarMedico(@PathVariable Long id){
		medicosService.deletarMedico(id);
		return ResponseEntity.noContent().build();
	}
}
