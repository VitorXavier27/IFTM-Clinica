package com.ClinicaMedica.IFTM.service;

import java.util.List;

import com.ClinicaMedica.IFTM.service.exceptions.ResourceNotFoundExeception;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ClinicaMedica.IFTM.dto.GuiaDTO;
import com.ClinicaMedica.IFTM.entities.Guia;
import com.ClinicaMedica.IFTM.repository.GuiaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuiaService {


    @Autowired
    private GuiaRepository guiaRepository;

    @Transactional(readOnly = true)
    public Page<GuiaDTO> findAll(Pageable pageable) {
        Page<Guia> guia = guiaRepository.findAll(pageable);
        return guia.map(x-> new GuiaDTO(x));
    }

    @Transactional(readOnly = true)
    public GuiaDTO findById(Long id){
        Guia result = guiaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeception("Guia não encontrada ou cadastrada"));
        return new GuiaDTO(result);
    }

    /*@Transactional
    public GuiaDTO cadastrarGuia(GuiaDTO dto){
        Guia entity = new Guia();

        entity.setData_Emissao_Guia(dto.getData_Emissao_Guia());
        entity.setConvenio_Guia(dto.getConvenio_Guia());
        entity.setNumero_Guia(dto.getNumero_Guia());

        entity = guiaRepository.save(entity);
        return new GuiaDTO(entity);
    }*/

    @Transactional
   /* public GuiaDTO atualizarGuia(Long id, GuiaDTO dto){
        try{
            Guia entity = guiaRepository.getReferenceById(id);
            entity.setData_Emissao_Guia(dto.getData_Emissao_Guia());
            entity.setConvenio_Guia(dto.getConvenio_Guia());
            entity.setNumero_Guia(dto.getNumero_Guia());
            entity = guiaRepository.save(entity);
            return new GuiaDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundExeception("Guia Não Encontrada ou Inexistente");
        }
    }*/

    public void deletarGuia(Long id) {

        if(!guiaRepository.existsById(id)) {
            throw new RuntimeException("Guia com ID " + id + "Guia nao encontrada,falha na exclusão");
        }
        guiaRepository.deleteById(id);
    }
}
