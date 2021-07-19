package com.t2m.skills.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.t2m.skills.entities.Skills;
import com.t2m.skills.repositories.SkillsRepository;
import com.t2m.skills.vo.SkillsVO;

@Service
public class SkillsService {
	@Autowired
	private SkillsRepository skillsRepository;
	
	public SkillsVO findByIdVO(Long id) {
		Skills skill = skillsRepository.getById(id);
		SkillsVO skillVO = converteEntidadeParaVO(skill);
		return skillVO;
	}
	
	private SkillsVO converteEntidadeParaVO(Skills skill) {
		SkillsVO skillVO = new SkillsVO();
		
		skillVO.setSkillsId(skill.getSkillsId());
		skillVO.setSkillsNome(skill.getSkillsNome());
		return skillVO;
	}

	public List<SkillsVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception{
		Pageable page = null;
		List<Skills> listaSkills = null;
		List<Skills> listaSkillsComPaginacao = null;
		List<SkillsVO> listaSkillsVO = new ArrayList<>();
		
		try {
			if(null !=pagina && qtdRegistros !=null) {
				page = PageRequest.of(pagina, qtdRegistros);
				listaSkillsComPaginacao = skillsRepository.findAll(page).getContent();
				
				for(Skills skills : listaSkillsComPaginacao) {
					listaSkillsVO.add(converteEntidadeParaVO(skills));
				}
			} else {
				listaSkills = skillsRepository.findAll();
				
				for(Skills skills : listaSkills) {
					listaSkillsVO.add(converteEntidadeParaVO(skills));
				}
			}
		} catch (Exception e ) {
			throw new Exception("Não foi possível recuperar a lista de Skills ::" + e.getMessage());
		}
		
		return listaSkillsVO;
	}
	
	public Long count() {
		return skillsRepository.count();
	}
	
	public SkillsVO saveVO(SkillsVO skillVO) {
		Skills skill = converteVOParaEntidade(skillVO,null);
		Skills newSkill = skillsRepository.save(skill);
		
		return converteEntidadeParaVO(newSkill);
	}

	private Skills converteVOParaEntidade(SkillsVO skillVO, Long id) {
		Skills skill = new Skills();
		
		skill.setSkillsId((id==null)?null:id);
		skill.setSkillsNome(skillVO.getSkillsNome());
		
		return skill;
	}
	
	public SkillsVO updateVO(SkillsVO skillVO, Long id) {
		Skills skill = skillsRepository.getById(id);
		skill = converteVOParaEntidade(skillVO,id);
		
		return converteEntidadeParaVO(skillsRepository.save(skill));
	}
	
	

}
