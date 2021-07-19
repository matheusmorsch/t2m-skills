package com.t2m.skills.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long usuariosId;

	@Size(min = 5, max = 25)
	@NotBlank(message = "Digite uma senha!")
	@Column(name = "senha")
	private String usuariosSenha;
	
	@Size(min = 5, max = 30)
	@NotBlank(message = "Digite o nome de usuário!")
	@Column(name = "nome_usuario")
	private String usuariosNomeUsuario;
	
	@Email
	@Size(min = 5, max = 50)
	@NotBlank(message = "Digite um email!")
	@Column(name = "email")
	private String usuariosEmail;

	@Size(min = 5, max = 50)
	@NotBlank(message = "Digite o seu nome!")
	@Column(name = "nome")
	private String usuariosNome;
	
	@CPF
	@Size(min = 11, max = 11)
	@NotBlank(message = "Digite o cpf!")
	@Column(name = "cpf")
	private String usuariosCpf;
	
	@Column(name = "ativo")
	private Boolean usuariosAtivo;
	
	@Size(min = 3, max = 10)
	@NotBlank(message = "Digite o tipo de usuário!")
	@Column(name = "tipo")
	private String usuariosTipo;

	public Long getUsuariosId() {
		return usuariosId;
	}

	public void setUsuariosId(Long usuariosId) {
		this.usuariosId = usuariosId;
	}

	public String getUsuariosSenha() {
		return usuariosSenha;
	}

	public void setUsuariosSenha(String usuariosSenha) {
		this.usuariosSenha = usuariosSenha;
	}

	public String getUsuariosNomeUsuario() {
		return usuariosNomeUsuario;
	}

	public void setUsuariosNomeUsuario(String usuariosNomeUsuario) {
		this.usuariosNomeUsuario = usuariosNomeUsuario;
	}

	public String getUsuariosEmail() {
		return usuariosEmail;
	}

	public void setUsuariosEmail(String usuariosEmail) {
		this.usuariosEmail = usuariosEmail;
	}

	public String getUsuariosNome() {
		return usuariosNome;
	}

	public void setUsuariosNome(String usuariosNome) {
		this.usuariosNome = usuariosNome;
	}

	public String getUsuariosCpf() {
		return usuariosCpf;
	}

	public void setUsuariosCpf(String usuarioCpf) {
		this.usuariosCpf = usuarioCpf;
	}

	public Boolean getUsuariosAtivo() {
		return usuariosAtivo;
	}

	public void setUsuariosAtivo(Boolean usuarioAtivo) {
		this.usuariosAtivo = usuarioAtivo;
	}

	public String getUsuariosTipo() {
		return usuariosTipo;
	}

	public void setUsuariosTipo(String usuarioTipo) {
		this.usuariosTipo = usuarioTipo;
	}
	
}
