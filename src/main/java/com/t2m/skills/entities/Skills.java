package com.t2m.skills.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class Skills {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long skillsId;
	
	@Column(name = "nome")
    private String skillsNome;
	
	//@ManyToOne
	//@JoinColumn (name="id_categoria", referencedColumnName="id")
	//private Categorias skillCategoria;
	
	@ManyToMany
	@JoinTable(
	  name = "pro_skill",
	  joinColumns = @JoinColumn(name = "id", referencedColumnName = "id_skill"),
	  inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id")
	)
	private List<Profissionais> listFilm;

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
	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	*/
	
}
