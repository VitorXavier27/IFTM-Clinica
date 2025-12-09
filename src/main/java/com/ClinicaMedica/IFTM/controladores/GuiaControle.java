package com.ClinicaMedica.IFTM.controladores;

import java.time.Instant;
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

import com.ClinicaMedica.IFTM.dto.GuiaDTO;
import com.ClinicaMedica.IFTM.entities.Guia;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.repository.GuiaRepository;
import com.ClinicaMedica.IFTM.repository.PacienteRepository;
import com.ClinicaMedica.IFTM.service.GuiaService;

@RestController
@CrossOrigin (origins = "http://localhost:5137")
@RequestMapping(value = "/guia")
@Tag(name = "Guia" , description = "Controlador para salvar e editar dados dos Guia!")
public class GuiaControle {

	@Autowired
	private GuiaService guiaService;
	
	@Autowired
	private GuiaRepository guiaRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
    @Operation(summary = "Busca os Guia salvos paginados em 10", description = "Metodo para buscar todos os Guias")
    @ApiResponse(responseCode = "200" , description = "Guia Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<Page<GuiaDTO>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        Page<GuiaDTO> dto = guiaService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
	
	/*@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
	public Guia cadastroGuia(@RequestBody Guia cadastroGuia) {
		Guia guiaSalva = guiaService.salvar(cadastroGuia);
		return guiaSalva;
	}*/
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    @Operation (summary = "Fazer o Cadastro dos Guia", description = "Metodo para Cadastrar Guias")
    @ApiResponse(responseCode = "201" , description = "Guia Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<?> criarGuia(@RequestBody GuiaDTO guiaDTO){
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(guiaDTO.getPacienteId());
		
		if(!pacienteOptional.isPresent()){
			return ResponseEntity.badRequest().body("Pacientecom ID " + guiaDTO.getPacienteId()+" Nao Encontrado");
		}
		
		Paciente pacienteEncontrado = pacienteOptional.get();
		
		Guia novoGuia = new Guia();
		novoGuia.setConvenio_Guia(guiaDTO.getConvenio_Guia());
		novoGuia.setData_Emissao_Guia(Instant.now());
		novoGuia.setNumero_Guia(guiaDTO.getNumero_Guia());
		
		novoGuia.setPaciente(pacienteEncontrado);
		
		Guia guiasSalvas = guiaRepository.save(novoGuia);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(guiasSalvas);
	}
	
	@CrossOrigin(origins = "*" , allowedHeaders = "*")
	@DeleteMapping("/{id}")
    @Operation (summary = "Deletar Dados dos Guias", description = "Metodo para Deletar Guias")
    @ApiResponse(responseCode = "204" , description = "Guias Deletado com Sucesso")
    @ApiResponse(responseCode = "404", description = "Guias Não Encontrado ou Inexistente")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
		public ResponseEntity<Guia> deletarGuia(@PathVariable Long id){
			guiaService.deletarGuia(id);
			
			return ResponseEntity.noContent().build();
		}
	}


