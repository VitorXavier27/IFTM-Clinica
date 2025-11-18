package com.ClinicaMedica.IFTM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.ExameDTO;
import com.ClinicaMedica.IFTM.entities.Exame;
import com.ClinicaMedica.IFTM.repository.ExameRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;
	
	public Page<ExameDTO> findAll(Pageable pageable){
        Page<Exame> page = exameRepository.findAll(pageable);
        return page.map(x-> new ExameDTO(x));
    }

	public Exame salvar(Exame exameCadastro) {
		return exameRepository.save(exameCadastro);
	}
	
	public void deletarExame(Long id) {
		if(!exameRepository.existsById(id)) {
			throw new RuntimeException("Exame com ID " + id + " Nao encontrado.Falha na exclusao!");
		}
		exameRepository.deleteById(id);
	}

    @Transactional(readOnly = true)
    public long contarTotaldeExame(){
        return exameRepository.count();
    }
}
