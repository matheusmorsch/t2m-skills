package com.t2m.skills.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2m.skills.entities.Profissionais;

@Repository
public interface ProfissionaisRepository extends JpaRepository<Profissionais, Long>{
		

}
