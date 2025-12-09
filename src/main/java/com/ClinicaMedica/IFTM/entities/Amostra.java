package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "tb_amostra")
public class Amostra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Amostra;
	private String codigo_Rastreamento_Amostra;
    private LocalDate data_Coleta;
    private StatusAmostra status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "id_pacientes" , referencedColumnName = "id_Paciente")
    private Paciente paciente;

	public Amostra() {
		
	}

	public Amostra(Long id_Amostra, String codigo_Rastreamento_Amostra,LocalDate data_Coleta,StatusAmostra status, Paciente paciente) {
		this.id_Amostra = id_Amostra;
		this.codigo_Rastreamento_Amostra = codigo_Rastreamento_Amostra;
        this.data_Coleta = data_Coleta;
        this.status = status;
        this.paciente = paciente;
	}

	public Long getId_Amostra() {
		return id_Amostra;
	}

	public void setId_Amostra(Long id_Amostra) {
		this.id_Amostra = id_Amostra;
	}

	public String getCodigo_Rastreamento_Amostra() {
		return codigo_Rastreamento_Amostra;
	}

	public void setCodigo_Rastreamento_Amostra(String codigo_Rastreamento_Amostra) {
		this.codigo_Rastreamento_Amostra = codigo_Rastreamento_Amostra;
	}

    public LocalDate getData_Coleta() {
        return data_Coleta;
    }

    public void setData_Coleta(LocalDate data_Coleta) {
        this.data_Coleta = data_Coleta;
    }

    public StatusAmostra getStatus() {
        return status;
    }

    public void setStatus(StatusAmostra status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getNome_paciente() {
        return paciente != null ? paciente.getNome_Paciente() : null;
    }
	
	public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
