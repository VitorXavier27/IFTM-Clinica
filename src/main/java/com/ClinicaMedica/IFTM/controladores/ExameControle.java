package com.ClinicaMedica.IFTM.controladores;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ClinicaMedica.IFTM.dto.ExameDTO;
import com.ClinicaMedica.IFTM.entities.Exame;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.repository.ExameRepository;
import com.ClinicaMedica.IFTM.repository.PacienteRepository;
import com.ClinicaMedica.IFTM.service.ExameService;

@RestController
@CrossOrigin(origins = "http://localhost:5137")
@RequestMapping(value = "/exame")
@Tag(name = "Exame" , description = "Controlador para salvar e editar dados dos Exames!")
public class ExameControle {

	@Autowired
	private ExameService exameService;
	
	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
    @Operation(summary = "Busca os Exame salvos paginados em 10", description = "Metodo para buscar todos os Exame")
    @ApiResponse(responseCode = "200" , description = "Exame Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<Page<ExameDTO>> findAll(@PageableDefault(size = 10) Pageable pageable){
        Page<ExameDTO> dto = exameService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
		
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    @Operation (summary = "Fazer o Cadastro dos Exames", description = "Metodo para Cadastrar Exames")
    @ApiResponse(responseCode = "201" , description = "Exame Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<?> criarExame(@RequestBody ExameDTO exameDTO){
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(exameDTO.getPacienteId());
		
		if(!pacienteOptional.isPresent()) {
			return ResponseEntity.badRequest().body("Paciente com ID " + exameDTO.getPacienteId()+" Nao Encontrado");
		}
		
		Paciente pacienteEncontrado = pacienteOptional.get();
		
		Exame novoExame = new Exame();
		novoExame.setTipo_Exame(exameDTO.getTipo_Exame());
		novoExame.setResultado_Exame(exameDTO.getResultado_Exame());
		novoExame.setData_Exame(exameDTO.getData_Exame());
		
		novoExame.setPaciente(pacienteEncontrado);
		
		Exame exameSalvos = exameRepository.save(novoExame);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(exameSalvos);
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Exame", description = "Metodo para Deletar Exames")
    @ApiResponse(responseCode = "204" , description = "Exame Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Examea Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
		public ResponseEntity<Exame> deletarExame(@PathVariable Long id){
			exameService.deletarExame(id);
			
			return ResponseEntity.noContent().build();
	}

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @GetMapping("/total")
    @Operation (summary = "Saber a Quantidade de Exames", description = "Metodo para Saber a quantidade de  Exames")
    public ResponseEntity<Long> getTotalExames(){
        long total = exameService.contarTotaldeExame();
        return ResponseEntity.ok(total);
    }
}
