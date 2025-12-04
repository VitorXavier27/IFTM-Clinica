package com.ClinicaMedica.IFTM.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_medicos")
public class Medicos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Medico;
	private String nome_Medico;
	private String crm_Medico;
	private String especialidade_Medico;
	private String telefone_Medico;

    /*@ManyToMany(mappedBy = "medics")
    private Set<Paciente> pacientes = new HashSet<>();*/

    @OneToMany
    @Fetch(FetchMode.JOIN)
    private List<Paciente> pacientes;
	
	public Medicos() {
		
	}


	public Medicos(Long id_Medico, String nome_Medico, String crm_Medico, String especialidade_Medico,
			String telefone_Medico, Set<Paciente> pacientes) {
		super();
		this.id_Medico = id_Medico;
		this.nome_Medico = nome_Medico;
		this.crm_Medico = crm_Medico;
		this.especialidade_Medico = especialidade_Medico;
		this.telefone_Medico = telefone_Medico;
//        this.pacientes = pacientes;
	}


	public Long getId_Medico() {
		return id_Medico;
	}


	public void setId_Medico(Long id_Medico) {
		this.id_Medico = id_Medico;
	}


	public String getNome_Medico() {
		return nome_Medico;
	}


	public void setNome_Medico(String nome_Medico) {
		this.nome_Medico = nome_Medico;
	}


	public String getCrm_Medico() {
		return crm_Medico;
	}


	public void setCrm_Medico(String crm_Medico) {
		this.crm_Medico = crm_Medico;
	}


	public String getEspecialidade_Medico() {
		return especialidade_Medico;
	}


	public void setEspecialidade_Medico(String especialidade_Medico) {
		this.especialidade_Medico = especialidade_Medico;
	}


	public String getTelefone_Medico() {
		return telefone_Medico;
	}


	public void setTelefone_Medico(String telefone_Medico) {
		this.telefone_Medico = telefone_Medico;
	}

//    public Set<Paciente> getPacientes() {
//        return pacientes;
//    }
}
