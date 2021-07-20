package com.t2m.skills.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmpresasVO {
	
	
	private Long empresasId;
	
	@NotBlank(message = "Insira um nome")
	@Size(max = 30, message = "Limite de so {max} caracteres")
	private String empresasNome;
	
	@NotBlank(message = "Insira o CNPJ da empresa")
	private String empresasCnpj;
	
	@NotBlank(message = "Insira a Razao Social da empresa")
	@Size(max = 50, message = "Limite de so {max} caracteres")
	private String empresasRazaoSocial;
	
	
	private boolean empresasAtivo;
	
	
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
