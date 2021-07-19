package com.t2m.skills.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long empresasId;
	
	@Column(name = "nome")
	private String empresasNome;
	
	@Column(name = "cnpj")
	private String empresasCnpj;
	
	@Column(name = "razao_social")
	private String empresasRazaoSocial;
	
	@Column(name = "ativo")
	private boolean empresasAtivo;
	
//	@ManyToMany
//	private List<Profissionais> listaProfissionais;

	public Long getEmpresasId() {
		return empresasId;
	}

	public void setEmpresasId(Long empresaId) {
		this.empresasId = empresaId;
	}

	public String getEmpresasNome() {
		return empresasNome;
	}

	public void setEmpresasNome(String empresaNome) {
		this.empresasNome = empresaNome;
	}

	public String getEmpresasCnpj() {
		return empresasCnpj;
	}

	public void setEmpresasCnpj(String empresaCnpj) {
		this.empresasCnpj = empresaCnpj;
	}

	public String getEmpresasRazaoSocial() {
		return empresasRazaoSocial;
	}

	public void setEmpresasRazaoSocial(String empresaRazaoSocial) {
		this.empresasRazaoSocial = empresaRazaoSocial;
	}

	public boolean getEmpresasAtivo() {
		return empresasAtivo;
	}

	public void setEmpresasAtivo(boolean empresasAtivo) {
		this.empresasAtivo = empresasAtivo;
	}
	
}
