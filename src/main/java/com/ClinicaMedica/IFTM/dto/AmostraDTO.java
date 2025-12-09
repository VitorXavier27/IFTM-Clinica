package com.ClinicaMedica.IFTM.dto;

import com.ClinicaMedica.IFTM.entities.Amostra;
import com.ClinicaMedica.IFTM.entities.StatusAmostra;

import java.time.LocalDate;

public class AmostraDTO {

	private Long id_Amostra;
	private String codigo_Rastreamento_Amostra;
	private String status_Amostra;
    private LocalDate data_Coleta;
    private StatusAmostra status;
    private String nome_Paciente;
    private Long pacienteId;
	
	public AmostraDTO () {
		
	}
	
	public AmostraDTO (Amostra entity) {
		
		id_Amostra = entity.getId_Amostra();
		codigo_Rastreamento_Amostra = entity.getCodigo_Rastreamento_Amostra();
		status_Amostra = entity.getStatus_Amostra();
        data_Coleta = entity.getData_Coleta();
        status = entity.getStatus();
        nome_Paciente = entity.getNome_paciente()!=null? entity.getNome_paciente(): null;
	}

	public Long getId_Amostra() {
		return id_Amostra;
	}

	public String getCodigo_Rastreamento_Amostra() {
		return codigo_Rastreamento_Amostra;
	}

	public String getStatus_Amostra() {
		return status_Amostra;
	}

    public LocalDate getData_Coleta() {
        return data_Coleta;
    }

    public StatusAmostra getStatus() {
        return status;
    }

    public String getNome_Paciente() {
        return nome_Paciente;
    }

    public Long getPacienteId(){
        return pacienteId;
    }
}
