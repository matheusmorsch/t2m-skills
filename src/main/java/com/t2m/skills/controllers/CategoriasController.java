package com.t2m.skills.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2m.skills.services.CategoriasService;
import com.t2m.skills.vo.CategoriasVO;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriasService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<CategoriasVO>> listar() {
		return ResponseEntity.ok(categoriaService.listar());
	}
	
	@GetMapping("{nome}") 
	public ResponseEntity<List<CategoriasVO>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(categoriaService.buscarPorNome(nome));
	}
	
}
