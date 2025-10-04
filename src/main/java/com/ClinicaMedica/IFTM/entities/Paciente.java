package com.ClinicaMedica.IFTM.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Paciente;
	private String nome_Paciente;
	private String cpf_Paciente;
	private LocalDate data_Nascimento_Paciente;
	private String endereco_Paciente;
	private String telefone_Paciente;
	private String email_Paciente;
	@OneToMany(mappedBy = "paciente")
	@Fetch (FetchMode.JOIN)
	private List<Exame> exames;
	
	public Paciente() {
		
	}

	public Paciente(Long id_Paciente, String nome_Paciente, String cpf_Paciente, LocalDate data_Nascimento_Paciente,
			String endereco_Paciente, String telefone_Paciente, String email_Paciente) {
		super();
		this.id_Paciente = id_Paciente;
		this.nome_Paciente = nome_Paciente;
		this.cpf_Paciente = cpf_Paciente;
		this.data_Nascimento_Paciente = data_Nascimento_Paciente;
		this.endereco_Paciente = endereco_Paciente;
		this.telefone_Paciente = telefone_Paciente;
		this.email_Paciente = email_Paciente;
	}

	public Long getId_Paciente() {
		return id_Paciente;
	}

	public void setId_Paciente(Long id_Paciente) {
		this.id_Paciente = id_Paciente;
	}

	public String getNome_Paciente() {
		return nome_Paciente;
	}

	public void setNome_Paciente(String nome_Paciente) {
		this.nome_Paciente = nome_Paciente;
	}

	public String getCpf_Paciente() {
		return cpf_Paciente;
	}

	public void setCpf_Paciente(String cpf_Paciente) {
		this.cpf_Paciente = cpf_Paciente;
	}

	public LocalDate getData_Nascimento_Paciente() {
		return data_Nascimento_Paciente;
	}

	public void setData_Nascimento_Paciente(LocalDate data_Nascimento_Paciente) {
		this.data_Nascimento_Paciente = data_Nascimento_Paciente;
	}

	public String getEndereco_Paciente() {
		return endereco_Paciente;
	}

	public void setEndereco_Paciente(String endereco_Paciente) {
		this.endereco_Paciente = endereco_Paciente;
	}

	public String getTelefone_Paciente() {
		return telefone_Paciente;
	}

	public void setTelefone_Paciente(String telefone_Paciente) {
		this.telefone_Paciente = telefone_Paciente;
	}

	public String getEmail_Paciente() {
		return email_Paciente;
	}

	public void setEmail_Paciente(String email_Paciente) {
		this.email_Paciente = email_Paciente;
	}


	
	
}
