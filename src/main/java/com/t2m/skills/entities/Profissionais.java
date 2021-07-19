package com.t2m.skills.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "profissionais")
public class Profissionais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "profissionais")
	private Long profissionaisId;
	
    @Column(name = "nome")
	private String profissionaisNome;

	@Column(name = "data_nasc")
	private LocalDate profissionaisDataNasc;
	
	@Column(name = "cpf")
    private String profissionaisCpf;

	@Column(name = "email")
    private String profissionaisEmail;
	
	@Column(name = "ativo")
	private Boolean profissionalAtivo;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profissionaisCpf == null) ? 0 : profissionaisCpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissionais other = (Profissionais) obj;
		if (profissionaisCpf == null) {
			if (other.profissionaisCpf != null)
				return false;
		} else if (!profissionaisCpf.equals(other.profissionaisCpf))
			return false;
		return true;
	}

	public Profissionais(Long profissionaisId,
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

	public Profissionais() {
		super();
	}
	
	
}
