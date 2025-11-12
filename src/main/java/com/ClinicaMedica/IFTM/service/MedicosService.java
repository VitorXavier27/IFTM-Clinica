package com.ClinicaMedica.IFTM.service;

import java.util.List;

import com.ClinicaMedica.IFTM.service.exceptions.ResourceNotFoundExeception;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.MedicosDTO;
import com.ClinicaMedica.IFTM.entities.Medicos;
import com.ClinicaMedica.IFTM.repository.MedicosRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicosService {

	@Autowired
	private MedicosRepository medicosRepository;

    @Transactional(readOnly = true)
    public Page<MedicosDTO> findAll(Pageable pageable) {
        Page<Medicos> resultado = medicosRepository.findAll(pageable);
        return resultado.map(x-> new MedicosDTO(x));
    }

    @Transactional(readOnly = true)
    public MedicosDTO findById(Long id) {
        Medicos medicos = medicosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("Medico não encontrado"));
        return new MedicosDTO(medicos);
    }
	
	@Transactional
    public MedicosDTO cadastroMedico(MedicosDTO dto){
        Medicos entity = new Medicos();
        entity.setNome_Medico(dto.getNome_Medico());
        entity.setCrm_Medico(dto.getCrm_Medico());
        entity.setEspecialidade_Medico(dto.getEspecialidade_Medico());
        entity.setTelefone_Medico(dto.getTelefone_Medico());

        entity = medicosRepository.save(entity);
        return new MedicosDTO(entity);
    }

    @Transactional
    public MedicosDTO atualizarMedico(Long id, MedicosDTO dto){
        try{
            Medicos entity = medicosRepository.getReferenceById(id);
            entity.setNome_Medico(dto.getNome_Medico());
            entity.setCrm_Medico(dto.getCrm_Medico());
            entity.setEspecialidade_Medico(dto.getEspecialidade_Medico());
            entity.setTelefone_Medico(dto.getTelefone_Medico());
            entity = medicosRepository.save(entity);
            return new MedicosDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundExeception("Medico nao encontrado");
        }
    }

    public void deletarMedico(Long id){
        if(medicosRepository.existsById(id)){
            throw new ResourceNotFoundExeception("Medico nao encontrado");
        }
        try{
            medicosRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Falha ao deletar medico");
        }
    }
	
	/*public void deletarPorId(Long id) {
		
		if(!medicosRepository.existsById(id)) {
			throw new RuntimeException("Medico com ID " + id + " não encontrado,falha na exclusao");
		}
			medicosRepository.deleteById(id);
	}*/
}
