package com.t2m.skills.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.t2m.skills.entities.Usuarios;
import com.t2m.skills.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosService usuariosService;

	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuariosService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Usuarios>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuariosService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return usuariosService.count();
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<List<Usuarios>> findAll(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(usuariosService.findAll(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Usuarios> save(@PathVariable Long id, @RequestBody Usuarios usuarios) {
		HttpHeaders headers = new HttpHeaders();

		if (null != usuariosService.save(usuarios))
			return new ResponseEntity<>(usuariosService.save(usuarios), headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(usuariosService.save(usuarios), headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Usuarios update(@PathVariable Long id, @RequestBody Usuarios usuarios) {
		return usuariosService.update(id, usuarios);
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Usuarios> delete(@PathVariable Long id){
		HttpHeaders headers = new HttpHeaders();
		boolean isRemoved = usuariosService.delete(id);
		if(isRemoved) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

}
