package com.ClinicaMedica.IFTM.controladores;

import java.net.URI;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Laudo" , description = "Controlador para salvar e editar dados dos Laudos!")
public class LaudoControle {

	@Autowired
	private LaudoService laudoService;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
    @Operation(summary = "Busca os Laudos salvos paginados em 10", description = "Metodo para buscar todos os Laudos")
    @ApiResponse(responseCode = "200" , description = "Laudo Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<Page<LaudoDTO>> findAll(Pageable pageable){
        Page<LaudoDTO> dto = laudoService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @GetMapping("/{id}")
    @Operation (summary = "Busca os Laudo por ID", description = "Metodo para buscar Laudo por ID")
    @ApiResponse(responseCode = "200" , description = "Laudo Buscado com sucesso")
    @ApiResponse(responseCode = "404", description = "Laudo Não Cadastrado ou nao Encontrado")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<LaudoDTO> findById(@PathVariable Long id){
        LaudoDTO dto = laudoService.findById(id);
        return ResponseEntity.ok(dto);
    }

	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    @Operation (summary = "Fazer o Cadastro dos Laudos", description = "Metodo para Cadastrar Laudos")
    @ApiResponse(responseCode = "201" , description = "Laudo Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<LaudoDTO> criarLaudo(@RequestBody LaudoDTO dto){
        dto = laudoService.cadastroLaudo(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId_Laudo()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @PutMapping(value = "/{id}")
    @Operation (summary = "Atualiza Dados dos Laudos", description = "Metodo para Atualizar Laudos")
    @ApiResponse(responseCode = "200" , description = "Laudo Atualizado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Laudo Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<LaudoDTO> atualizarLaudo(@PathVariable Long id, @RequestBody LaudoDTO dto){
        dto = laudoService.atualizarLaudo(id, dto);
        return ResponseEntity.ok(dto);
    }
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Laudos", description = "Metodo para Deletar Laudos")
    @ApiResponse(responseCode = "204" , description = "Laudo Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Laudo Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<Laudo> deleteById(@PathVariable Long id){
		laudoService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
