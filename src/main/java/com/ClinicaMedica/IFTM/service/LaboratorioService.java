package com.ClinicaMedica.IFTM.service;

import java.util.List;

import com.ClinicaMedica.IFTM.service.exceptions.ResourceNotFoundExeception;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.LaboratorioDTO;
import com.ClinicaMedica.IFTM.entities.Laboratorio;
import com.ClinicaMedica.IFTM.repository.LaboratorioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LaboratorioService {

	@Autowired
	private LaboratorioRepository laboratorioRepository;
	
    @Transactional(readOnly = true)
    public Page<LaboratorioDTO> findAll(Pageable pageable) {
        Page<Laboratorio> labotorio = laboratorioRepository.findAll(pageable);
        return labotorio.map(x->new LaboratorioDTO(x));
    }
	
	@Transactional(readOnly = true)
    public LaboratorioDTO findById(Long id) {
        Laboratorio laboratorio = laboratorioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("Laboratorio não encontrado"));
        return new LaboratorioDTO(laboratorio);
    }

    @Transactional
    public LaboratorioDTO cadastrarLaboratorio(LaboratorioDTO dto) {
        Laboratorio entity = new Laboratorio();

        entity.setNome_Laboratorio(dto.getNome_Laboratorio());
        entity.setEndereco_Laboratio(dto.getEndereco_Laboratio());
        entity.setResponsavel_Tecnico_laboratorio(dto.getResponsavel_Tecnico_laboratorio());

        entity = laboratorioRepository.save(entity);
        return new LaboratorioDTO(entity);
    }

    @Transactional
    public LaboratorioDTO atualizarLaboratorio(Long id, LaboratorioDTO dto) {
        try{
            Laboratorio entity = laboratorioRepository.getReferenceById(id);
            entity.setNome_Laboratorio(dto.getNome_Laboratorio());
            entity.setEndereco_Laboratio(dto.getEndereco_Laboratio());
            entity.setResponsavel_Tecnico_laboratorio(dto.getResponsavel_Tecnico_laboratorio());
            entity = laboratorioRepository.save(entity);
            return new LaboratorioDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundExeception("Laboratorio Não encontrado ou inexistente");
        }
    }
	
	public void deleteById(Long id) {
		
		if(!laboratorioRepository.existsById(id)) {
			throw new RuntimeException("Id Laboratorio: " + id + " Nao Encontrado. Falha na exclusao");
		}
		
		laboratorioRepository.deleteById(id);
	}
}
