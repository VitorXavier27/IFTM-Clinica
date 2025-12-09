package com.ClinicaMedica.IFTM.controladores;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaMedica.IFTM.dto.TipoAnaliseDTO;
import com.ClinicaMedica.IFTM.entities.TipoAnalise;
import com.ClinicaMedica.IFTM.service.TipoAnaliseService;

@RestController
@CrossOrigin(origins = "http://localhost:5137")
@RequestMapping(value = "/tipoAnalise")
public class TipoAnaliseControle {

	@Autowired
	private TipoAnaliseService tipoAnaliseService;
	
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
    @Operation(summary = "Busca os Tipos de Analises salvos paginados em 10", description = "Metodo para buscar todos os Analises")
    @ApiResponse(responseCode = "200" , description = "Analise Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public List<TipoAnaliseDTO> findAll(){
		List<TipoAnaliseDTO> result = tipoAnaliseService.findAll();
		return result;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    @Operation (summary = "Fazer o Cadastro dos Analises", description = "Metodo para Cadastrar Analises")
    @ApiResponse(responseCode = "201" , description = "Analise Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public TipoAnalise cadastroTipoAnalise(@RequestBody TipoAnalise cadastroTipoAnalise) {
		TipoAnalise tipoAnaliseSalvo = tipoAnaliseService.save(cadastroTipoAnalise);
		return tipoAnaliseSalvo;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Analises", description = "Metodo para Deletar Analises")
    @ApiResponse(responseCode = "204" , description = "Analise Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Analise Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
		public ResponseEntity<TipoAnalise> deletarTipoAnalise(@PathVariable Long id){
			tipoAnaliseService.deleteById(id);
			
			return ResponseEntity.noContent().build();
	}
}
