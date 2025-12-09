package com.ClinicaMedica.IFTM.controladores;

import java.net.URI;
import java.util.List;

import com.ClinicaMedica.IFTM.infra.security.SecurityConfigurations;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "paciente" , description = "Controlador para salvar e editar dados dos pacientes!")
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class PacienteControle {

	@Autowired
	private PacienteService pacienteService;
	
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
    @Operation (summary = "Busca os pacientes salvos paginados em 10", description = "Metodo para buscar todos os Pacientes")
    @ApiResponse(responseCode = "200" , description = "Paciente Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<Page<PacienteDTO>> findAll(@PageableDefault(size = 10) Pageable pageable){
        Page<PacienteDTO> dto = pacienteService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping(value = "/{id}")
    @Operation (summary = "Busca os pacientes por ID", description = "Metodo para buscar Paciente por ID")
    @ApiResponse(responseCode = "200" , description = "Paciente Buscado com sucesso")
    @ApiResponse(responseCode = "404", description = "Paciente Não Cadastrado ou nao Encontrado")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public PacienteDTO findById(@PathVariable Long id) {
		PacienteDTO result = pacienteService.findById(id);
		return result;
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    @Operation (summary = "Fazer o Cadastro dos Pacientes", description = "Metodo para Cadastrar Pacientes")
    @ApiResponse(responseCode = "201" , description = "Paciente Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<PacienteDTO> insert(@RequestBody PacienteDTO dto){
        dto = pacienteService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getIdPaciente()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    @Operation (summary = "Atualiza Dados dos Pacientes", description = "Metodo para Atualizar Pacientes")
    @ApiResponse(responseCode = "200" , description = "Paciente Atualizado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Paciente Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
    public ResponseEntity<PacienteDTO>update(@PathVariable Long id, @RequestBody PacienteDTO dto){
        dto = pacienteService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Pacientes", description = "Metodo para Deletar Pacientes")
    @ApiResponse(responseCode = "204" , description = "Paciente Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Paciente Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<Void> deletarPaciente(@PathVariable  Long id) {
		pacienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
    @GetMapping("/total")
    @Operation (summary = "Saber a Quantidade de Pacientes", description = "Metodo para Saber a quantidade de  Pacientes")
    public ResponseEntity<Long> getTotalPacientes(){
        long total = pacienteService.contarTotalDePaciente();
        return ResponseEntity.ok(total);
    }
}
