package com.t2m.skills.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SkillsVO {
	private Long skillsId;
	@NotNull
	@Size(min=5, max=30)
	private String skillsNome;
	//private CategoriaVO categoria;
	
	public Long getSkillsId() {
		return skillsId;
	}
	public void setSkillsId(Long skillsId) {
		this.skillsId = skillsId;
	}
	public String getSkillsNome() {
		return skillsNome;
	}
	public void setSkillsNome(String skillsNome) {
		this.skillsNome = skillsNome;
	}
	/*
	public CategoriaVO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaVO categoria) {
		this.categoria = categoria;
	}
	
	*/

}
