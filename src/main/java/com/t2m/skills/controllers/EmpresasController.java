package com.t2m.skills.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.t2m.skills.services.EmpresasService;
import com.t2m.skills.vo.EmpresasVO;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {
	
	@Autowired
	private EmpresasService empresasService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpresasVO> findById(@PathVariable Long id){
		HttpHeaders headers = new HttpHeaders();
		
		EmpresasVO empresasVO = empresasService.findById(id);
		
		if (empresasVO.getEmpresasAtivo()) {
			return new ResponseEntity<>(empresasVO, headers, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, headers, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<List<EmpresasVO>> findAll(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(empresasService.findAll(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return empresasService.count();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> save(@Valid @RequestBody EmpresasVO empresasVO){
		HttpHeaders headers = new HttpHeaders();
		EmpresasVO novaEmpresaVO = empresasService.save(empresasVO);
		return new ResponseEntity<>("Empresa" + novaEmpresaVO.getEmpresasNome() + "cadastrada com Sucesso", headers, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmpresasVO> update(@PathVariable Long id,@Valid @RequestBody EmpresasVO empresasVO){
		HttpHeaders headers = new HttpHeaders();
		EmpresasVO empresaAtualizadaVO = empresasService.update(id, empresasVO);
		return new ResponseEntity<>(empresaAtualizadaVO, headers, HttpStatus.OK);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		HttpHeaders headers = new HttpHeaders();
		
		EmpresasVO empresasVO = empresasService.findById(id);
		
		if (empresasVO != null) {
			empresasService.delete(id);
			return new ResponseEntity<>("Empresa Deletada", headers, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Empresa Inexistente", headers, HttpStatus.BAD_REQUEST);
		}
	}
	
}
