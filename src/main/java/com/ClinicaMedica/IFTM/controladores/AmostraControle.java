package com.ClinicaMedica.IFTM.controladores;

import java.util.List;
import java.util.Optional;

import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.repository.AmostraRepository;
import com.ClinicaMedica.IFTM.repository.PacienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ClinicaMedica.IFTM.dto.AmostraDTO;
import com.ClinicaMedica.IFTM.entities.Amostra;
import com.ClinicaMedica.IFTM.service.AmostraService;

@RestController
@RequestMapping(value = "/amostra")
@CrossOrigin(origins = "http://localhost:5137")
public class AmostraControle {

	@Autowired
	private AmostraService amostraService;

    @Autowired
    private AmostraRepository amostraRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
	@GetMapping
    @Operation(summary = "Busca os Amostras salvos paginados em 10", description = "Metodo para buscar todos os Amostras")
    @ApiResponse(responseCode = "200" , description = "Amostra Buscado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public List<AmostraDTO> findAll(){
		List<AmostraDTO> result = amostraService.findAll();
		return result;
	}

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
	@PostMapping
    @Operation (summary = "Fazer o Cadastro das Amostras", description = "Metodo para Cadastrar Amostras")
    @ApiResponse(responseCode = "201" , description = "Amostra Cadastrado com Sucesso")
    @ApiResponse(responseCode = "403", description = "Usuario nao Cadastrado")
	public ResponseEntity<?> CadastroAmostra(@RequestBody AmostraDTO amostraDTO) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(amostraDTO.getPacienteId());

        if(!pacienteOptional.isPresent()){
            return ResponseEntity.badRequest().body("Paciente com ID" + amostraDTO.getPacienteId() + " Não Encontrado");
        }

        Paciente pacienteEncontrado = pacienteOptional.get();

        Amostra novaAmostra = new Amostra();
        novaAmostra.setCodigo_Rastreamento_Amostra(amostraDTO.getCodigo_Rastreamento_Amostra());
        novaAmostra.setStatus_Amostra(amostraDTO.getStatus_Amostra());
        novaAmostra.setData_Coleta(amostraDTO.getData_Coleta());
        novaAmostra.setStatus(amostraDTO.getStatus());

        novaAmostra.setPaciente(pacienteEncontrado);

        Amostra amostraSalva = amostraRepository.save(novaAmostra);

		return ResponseEntity.status(HttpStatus.CREATED).body(amostraSalva);
	}

    @CrossOrigin(origins = "*" , allowedHeaders = "*")
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
