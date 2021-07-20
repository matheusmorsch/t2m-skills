package com.t2m.skills.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2m.skills.entities.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long>{
	List<Categorias> findAllByNomeContaining (String nome);
}
