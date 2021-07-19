package com.t2m.skills.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.t2m.skills.entities.Usuarios;
import com.t2m.skills.repositories.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	public UsuariosRepository usuariosRepository;

	public Usuarios findById(Long id) {
		return usuariosRepository.findById(id).get();
	}
	
	public List<Usuarios> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Usuarios> listaUsuarios = null;
		List<Usuarios> listaUsuariosComPaginacao = null;
		List<Usuarios> listaUsuarios2 = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listaUsuariosComPaginacao = usuariosRepository.findAll(page).getContent();

				for (Usuarios lUsuarios : listaUsuariosComPaginacao) {
					listaUsuarios2.add(lUsuarios);
				}

			} else {
				listaUsuarios = usuariosRepository.findAll();

				for (Usuarios lUsuarios : listaUsuarios) {
					listaUsuarios2.add(lUsuarios);
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de Empresas ::" + e.getMessage());
		}

		return listaUsuarios2;
	}

	public List<Usuarios> findAll() {
		List<Usuarios> listUsuarios = usuariosRepository.findAll();
		List<Usuarios> mostrarUsuarios = new ArrayList<>();

		for (Usuarios usuarios : listUsuarios) {
			if (usuarios.getUsuariosAtivo()) {
				mostrarUsuarios.add(usuarios);
			}
		}
		return mostrarUsuarios;
	}

	public Long count() {
		return usuariosRepository.count();
	}

	public Usuarios save(Usuarios usuario) {
		Usuarios novoUsuario = usuariosRepository.save(usuario);
		if (novoUsuario.getUsuariosId() != null) {
			return novoUsuario;
		} else {
			return null;
		}
	}

	public Usuarios update(Long id, Usuarios usuario) {
		Usuarios novoUsuario = usuariosRepository.findById(id).get();
		updateDados(novoUsuario, usuario);
		return usuariosRepository.save(novoUsuario);
	}

	private void updateDados(Usuarios novoUsuario, Usuarios usuario) {
		novoUsuario.setUsuariosNome(usuario.getUsuariosNome());
		novoUsuario.setUsuariosCpf(usuario.getUsuariosCpf());
		novoUsuario.setUsuariosEmail(usuario.getUsuariosEmail());
		novoUsuario.setUsuariosSenha(usuario.getUsuariosSenha());
		novoUsuario.setUsuariosId(usuario.getUsuariosId());
		novoUsuario.setUsuariosNomeUsuario(usuario.getUsuariosNomeUsuario());
		novoUsuario.setUsuariosAtivo(usuario.getUsuariosAtivo());
		novoUsuario.setUsuariosTipo(usuario.getUsuariosTipo());
	}

	public boolean delete(Long id) {
		if (id != null) {
			Usuarios novoUsuario = usuariosRepository.findById(id).get();
			novoUsuario.setUsuariosAtivo(false);
			usuariosRepository.save(novoUsuario);
			return true;
		} else {
			return false;
		}
	}

}
