package com.ClinicaMedica.IFTM.controladores;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaMedica.IFTM.dto.ColetaDTO;
import com.ClinicaMedica.IFTM.entities.Coleta;
import com.ClinicaMedica.IFTM.service.ColetaService;

@RestController
@RequestMapping(value = "/coleta")
@Tag(name = "coleta" , description = "Controlador para salvar e editar dados dos coletas!")
public class ColetaControle {

	
	@Autowired
	private ColetaService coletaService;
	
	@GetMapping
    @Operation(summary = "Busca os Coleta salvos paginados em 10", description = "Metodo para buscar todos os Coleta")
    @ApiResponse(responseCode = "200" , description = "Coleta Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public List<ColetaDTO> findAll(){
		List<ColetaDTO> result = coletaService.findAll();
		return result;
	}
	
	@PostMapping
    @Operation (summary = "Fazer o Cadastro dos Coleta", description = "Metodo para Cadastrar Coleta")
    @ApiResponse(responseCode = "201" , description = "Coleta Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public Coleta cadastroColeta(@RequestBody Coleta cadastroColeta) {
		Coleta coletaSalva = coletaService.save(cadastroColeta);
		return coletaSalva;
	}
	
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Coletas", description = "Metodo para Deletar Coletas")
    @ApiResponse(responseCode = "204" , description = "Coleta Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Coleta Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
		public ResponseEntity<Coleta> deletarColeta(@PathVariable Long id){
			coletaService.deleteById(id);
			
			return ResponseEntity.noContent().build();
	}
}
