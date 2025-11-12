package com.ClinicaMedica.IFTM.service;

import java.util.List;

import com.ClinicaMedica.IFTM.service.exceptions.ResourceNotFoundExeception;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.LaudoDTO;
import com.ClinicaMedica.IFTM.entities.Laudo;
import com.ClinicaMedica.IFTM.repository.LaudoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LaudoService {

	@Autowired
	private LaudoRepository laudoRepository;

    @Transactional(readOnly = true)
	public Page<LaudoDTO> findAll(Pageable pageable){
        Page<Laudo> result = laudoRepository.findAll(pageable);
        return result.map(x-> new LaudoDTO(x));
    }

    @Transactional(readOnly = true)
    public LaudoDTO findById(Long id){
        Laudo laudo = laudoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundExeception("Laudo nao Encontrado"));
        return new LaudoDTO(laudo);
    }
	
	@Transactional
    public LaudoDTO cadastroLaudo(LaudoDTO dto){
        Laudo entity = new Laudo();

        entity.setTipo_Laudo(dto.getTipo_Laudo());
        entity = laudoRepository.save(entity);
        return new LaudoDTO(entity);
    }

    @Transactional
    public LaudoDTO atualizarLaudo(Long id, LaudoDTO dto){
        try{
            Laudo entity = laudoRepository.getReferenceById(id);
            entity.setTipo_Laudo(dto.getTipo_Laudo());
            entity = laudoRepository.save(entity);
            return new LaudoDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundExeception("Laudo nao encontrado");
        }
    }
	
	public void deleteById(Long id) {
		
		if(!laudoRepository.existsById(id)) {
			throw new RuntimeException("Laudo ID: " + id + " Não encontrado,Falha na exclusao");
		}
			laudoRepository.deleteById(id);
	}
}
