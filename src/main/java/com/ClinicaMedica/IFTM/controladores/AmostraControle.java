package com.ClinicaMedica.IFTM.controladores;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaMedica.IFTM.dto.AmostraDTO;
import com.ClinicaMedica.IFTM.entities.Amostra;
import com.ClinicaMedica.IFTM.service.AmostraService;

@RestController
@RequestMapping(value = "/amostra")
public class AmostraControle {

	@Autowired
	private AmostraService amostraService;
	
	@GetMapping
    @Operation(summary = "Busca os Amostras salvos paginados em 10", description = "Metodo para buscar todos os Amostras")
    @ApiResponse(responseCode = "200" , description = "Amostra Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public List<AmostraDTO> findAll(){
		List<AmostraDTO> result = amostraService.findAll();
		return result;
	}
	
	@PostMapping
    @Operation (summary = "Fazer o Cadastro das Amostras", description = "Metodo para Cadastrar Amostras")
    @ApiResponse(responseCode = "201" , description = "Amostra Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public Amostra CadastroAmostra(@RequestBody Amostra cadastroAmostra) {
		Amostra amostraSalva = amostraService.salvar(cadastroAmostra);
		return amostraSalva;
	}
	
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Amostras", description = "Metodo para Deletar Amostras")
    @ApiResponse(responseCode = "204" , description = "Amostra Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Amostra Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
		public ResponseEntity<Amostra> deletarAmostra(@PathVariable Long id){
			amostraService.deletarExame(id);
			
			return ResponseEntity.noContent().build();
	}
}
