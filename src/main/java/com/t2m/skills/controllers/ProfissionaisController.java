package com.t2m.skills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2m.skills.services.ProfissionaisService;

@RestController
@RequestMapping ("/profissionais")
public class ProfissionaisController {
	@Autowired
	private ProfissionaisService profissionaisService;

}
