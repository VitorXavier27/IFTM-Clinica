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

import com.ClinicaMedica.IFTM.dto.LaboratorioDTO;
import com.ClinicaMedica.IFTM.entities.Laboratorio;
import com.ClinicaMedica.IFTM.service.LaboratorioService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/laboratorio")
@Tag(name = "Laboratorio" , description = "Controlador para salvar e editar dados dos Laboratorios!")
public class LaboratorioControle {

	@Autowired
	private LaboratorioService laboratorioService;
	
	@GetMapping
    @Operation(summary = "Busca os Laboratorio salvos paginados em 10", description = "Metodo para buscar todos os Laboratorio")
    @ApiResponse(responseCode = "200" , description = "Laboratorio Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<Page<LaboratorioDTO>> findAll(@PageableDefault(size = 10) Pageable pageable){
        Page<LaboratorioDTO> dto = laboratorioService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}")
    @Operation (summary = "Busca os Laboratorio por ID", description = "Metodo para buscar Laboratorio por ID")
    @ApiResponse(responseCode = "200" , description = "Laboratorio Buscado com sucesso")
    @ApiResponse(responseCode = "404", description = "Laboratorio Não Cadastrado ou nao Encontrado")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public LaboratorioDTO findById(@PathVariable Long id){
        LaboratorioDTO dto = laboratorioService.findById(id);
        return dto;
    }
	
	@PostMapping
    @Operation (summary = "Fazer o Cadastro dos Laboratorio", description = "Metodo para Cadastrar Laboratorios")
    @ApiResponse(responseCode = "201" , description = "Laboratorio Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<LaboratorioDTO> salvarLaboratorio(@RequestBody LaboratorioDTO dto){
        dto = laboratorioService.cadastrarLaboratorio(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId_Laboratorio()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @Operation (summary = "Atualiza Dados dos Laboratorios", description = "Metodo para Atualizar Laboratorios")
    @ApiResponse(responseCode = "200" , description = "Laboratorio Atualizado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Laboratorio Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<LaboratorioDTO> atualizarLaboratorio(@PathVariable Long id, @RequestBody LaboratorioDTO dto){
        dto = laboratorioService.atualizarLaboratorio(id, dto);
        return ResponseEntity.ok(dto);
    }
	
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Laboratorios", description = "Metodo para Deletar Laboratorio")
    @ApiResponse(responseCode = "204" , description = "Laboratorio Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Laboratorio Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
		public ResponseEntity<Laboratorio> deletarLaboratorio(@PathVariable Long id){
			laboratorioService.deleteById(id);
			
			return ResponseEntity.noContent().build();
	}
}
