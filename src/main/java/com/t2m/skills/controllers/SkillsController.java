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
import org.springframework.web.bind.annotation.RestController;

import com.t2m.skills.services.SkillsService;
import com.t2m.skills.vo.SkillsVO;

@RestController
@RequestMapping("/skills")
public class SkillsController {

	@Autowired
	SkillsService skillsService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<SkillsVO> findById(@PathVariable Long id){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(skillsService.findByIdVO(id),headers,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<SkillsVO>>  findAll(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception{
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(skillsService.findAllVO(pagina,qtdRegistros),headers,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SkillsVO> save(@Valid @RequestBody SkillsVO skillVO){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(skillsService.saveVO(skillVO),headers,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SkillsVO> update(@Valid @RequestBody SkillsVO skillVO, @PathVariable Long id){
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(skillsService.updateVO(skillVO,id),headers,HttpStatus.OK);
	}

	
	
}
