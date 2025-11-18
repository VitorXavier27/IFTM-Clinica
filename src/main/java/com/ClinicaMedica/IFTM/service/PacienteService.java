package com.ClinicaMedica.IFTM.service;

import java.util.List;

import com.ClinicaMedica.IFTM.dto.MedicosDTO;
import com.ClinicaMedica.IFTM.entities.Medicos;
import com.ClinicaMedica.IFTM.repository.MedicosRepository;
import com.ClinicaMedica.IFTM.service.exceptions.DatabaseException;
import com.ClinicaMedica.IFTM.service.exceptions.ResourceNotFoundExeception;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ClinicaMedica.IFTM.dto.PacienteDTO;
import com.ClinicaMedica.IFTM.entities.Paciente;
import com.ClinicaMedica.IFTM.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

    @Autowired
    private MedicosRepository medicosRepository;


    @Transactional(readOnly = true)
    public Page<PacienteDTO> findAll(Pageable pageable) {
        Page<Paciente> result = pacienteRepository.findAll(pageable);
        return result.map(x-> new PacienteDTO(x));
    }
	

	@Transactional(readOnly = true)
		public PacienteDTO findById(Long id) {
			Paciente result = pacienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("Paciente Não Encontrado ou Inexistente"));
			return new PacienteDTO(result);
	}

    @Transactional
    public PacienteDTO insert(PacienteDTO dto){
        Paciente entity = new Paciente();

        entity.setNome_Paciente(dto.getNome_Paciente());
        entity.setCpf_Paciente(dto.getCpf_Paciente());
        entity.setData_Nascimento_Paciente(dto.getData_Nascimento_Paciente());
        entity.setEndereco_Paciente(dto.getEndereco_Paciente());
        entity.setTelefone_Paciente(dto.getTelefone_Paciente());
        entity.setEmail_Paciente(dto.getEmail_Paciente());

        entity = pacienteRepository.save(entity);

        return new PacienteDTO(entity);
    }

    @Transactional
    public PacienteDTO update(Long id, PacienteDTO dto) {
        try{
            Paciente entity = pacienteRepository.getReferenceById(id);
            entity.setNome_Paciente(dto.getNome_Paciente());
            entity.setCpf_Paciente(dto.getCpf_Paciente());
            entity.setData_Nascimento_Paciente(dto.getData_Nascimento_Paciente());
            entity.setEndereco_Paciente(dto.getEndereco_Paciente());
            entity.setTelefone_Paciente(dto.getTelefone_Paciente());
            entity.setEmail_Paciente(dto.getEmail_Paciente());

            entity = pacienteRepository.save(entity);
            return new PacienteDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundExeception("Paciente Não Encontrado ou Inexistente");
        }
    }

    public void delete(Long id) {
        if(!pacienteRepository.existsById(id)){
            throw new ResourceNotFoundExeception("Paciente Não Encontrado");
        }
        try{
            pacienteRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha ao deletar Paciente");
        }
    }

    @Transactional(readOnly = true)
    public long contarTotalDePaciente(){
        return pacienteRepository.count();
    }

}
