package com.t2m.skills.vo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ProfissionaisVO {

	private Long profissionaisId;
	
	@NotBlank(message = "Campo Nome do Profissional vazio")
    @Size(max = 50, message = "Nome acima de 50 caracteres")
	private String profissionaisNome;
	
	@Past
	private LocalDate profissionaisDataNasc;
	
	@NotBlank(message = "Campo CPF vazio")
    @Size(max = 11, message = "CPF invalido")
    @CPF(message = "CPF no formato invalido")
    private String profissionaisCpf;
	
	@NotBlank(message = "Campo EMAIL vazio")
    @Size(max = 50, message = "Email acima de 50 caracteres")
    @Email(message = "Email invalido")
    private String profissionaisEmail;
	
	private Boolean profissionalAtivo;

	public ProfissionaisVO() {
		super();
	}

	public ProfissionaisVO(Long profissionaisId,
			@NotBlank(message = "Campo Nome do Profissional vazio") @Size(max = 50, message = "Nome acima de 50 caracteres") String profissionaisNome,
			@Past LocalDate profissionaisDataNasc,
			@NotBlank(message = "Campo CPF vazio") @Size(max = 11, message = "CPF invalido") @CPF(message = "CPF no formato invalido") String profissionaisCpf,
			@NotBlank(message = "Campo EMAIL vazio") @Size(max = 50, message = "Email acima de 50 caracteres") @Email(message = "Email invalido") String profissionaisEmail,
			Boolean profissionalAtivo) {
		super();
		this.profissionaisId = profissionaisId;
		this.profissionaisNome = profissionaisNome;
		this.profissionaisDataNasc = profissionaisDataNasc;
		this.profissionaisCpf = profissionaisCpf;
		this.profissionaisEmail = profissionaisEmail;
		this.profissionalAtivo = profissionalAtivo;
	}

	public Long getProfissionaisId() {
		return profissionaisId;
	}

	public void setProfissionaisId(Long profissionaisId) {
		this.profissionaisId = profissionaisId;
	}

	public String getProfissionaisNome() {
		return profissionaisNome;
	}

	public void setProfissionaisNome(String profissionaisNome) {
		this.profissionaisNome = profissionaisNome;
	}

	public LocalDate getProfissionaisDataNasc() {
		return profissionaisDataNasc;
	}

	public void setProfissionaisDataNasc(LocalDate profissionaisDataNasc) {
		this.profissionaisDataNasc = profissionaisDataNasc;
	}

	public String getProfissionaisCpf() {
		return profissionaisCpf;
	}

	public void setProfissionaisCpf(String profissionaisCpf) {
		this.profissionaisCpf = profissionaisCpf;
	}

	public String getProfissionaisEmail() {
		return profissionaisEmail;
	}

	public void setProfissionaisEmail(String profissionaisEmail) {
		this.profissionaisEmail = profissionaisEmail;
	}

	public Boolean getProfissionalAtivo() {
		return profissionalAtivo;
	}

	public void setProfissionalAtivo(Boolean profissionalAtivo) {
		this.profissionalAtivo = profissionalAtivo;
	}
	
	

}
