package com.t2m.skills.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.t2m.skills.entities.Profissionais;
import com.t2m.skills.repositories.ProfissionaisRepository;
import com.t2m.skills.vo.ProfissionaisVO;


@Service
public class ProfissionaisService {
	
	@Autowired
	private ProfissionaisRepository profissionaisRepository;
	
	
	public Profissionais findById(Long id) {
		return profissionaisRepository.findById(id).get();
	}

	public List<ProfissionaisVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Profissionais> listaProfissionais = null;
		List<Profissionais> listaProfissionaisComPaginacao = null;
		List<ProfissionaisVO> listaProfissionaisVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listaProfissionaisComPaginacao = profissionaisRepository.findAll(page).getContent();

				for (Profissionais lProfissionais : listaProfissionaisComPaginacao) {
					listaProfissionaisVO.add(converteEntidadeParaVO(lProfissionais));
				}

			} else {
				listaProfissionais = profissionaisRepository.findAll();

				for (Profissionais lProfissionais : listaProfissionais) {
					listaProfissionaisVO.add(converteEntidadeParaVO(lProfissionais));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de Profissionais:" + e.getMessage());
		}

		return listaProfissionaisVO;
	}
	
	public Profissionais update(Long id, Profissionais profissionais) {
		Profissionais novoProfissional = profissionaisRepository.findById(id).get();
		updateDados(novoProfissional, profissionais);
		return profissionaisRepository.save(novoProfissional);
	}

	private void updateDados(Profissionais novoProfissional, Profissionais profissionais) {
		novoProfissional.setProfissionaisId(profissionais.getProfissionaisId());
		novoProfissional.setProfissionaisNome(profissionais.getProfissionaisNome());
		novoProfissional.setProfissionaisDataNasc(profissionais.getProfissionaisDataNasc());
		novoProfissional.setProfissionaisCpf(profissionais.getProfissionaisCpf());
		novoProfissional.setProfissionaisEmail(profissionais.getProfissionaisEmail());
	}
	
	public boolean delete(Long id) {
		if (id != null) {
			Profissionais novoProfissional = profissionaisRepository.findById(id).get();
			novoProfissional.setProfissionalAtivo(false);
			profissionaisRepository.save(novoProfissional);
			return true;
		} else {
			return false;
		}
	}
	
	public ProfissionaisVO converteEntidadeParaVO(Profissionais profissionais) {
		
		ProfissionaisVO profissionaisVO = new ProfissionaisVO();
		
		profissionaisVO.setProfissionaisId(profissionais.getProfissionaisId());
		profissionaisVO.setProfissionaisNome(profissionais.getProfissionaisNome());
		profissionaisVO.setProfissionaisCpf(profissionais.getProfissionaisCpf());
		profissionaisVO.setProfissionaisEmail(profissionais.getProfissionaisEmail());
		profissionaisVO.setProfissionalAtivo(profissionais.getProfissionalAtivo());
			
		return profissionaisVO;
	}
	
	public Profissionais converteVOParaEntidade(ProfissionaisVO profissionaisVO) {
		
		Profissionais profissionais = new Profissionais();
		
		profissionais.setProfissionaisId(profissionaisVO.getProfissionaisId());
		profissionais.setProfissionaisNome(profissionaisVO.getProfissionaisNome());
		profissionais.setProfissionaisCpf(profissionaisVO.getProfissionaisCpf());
		profissionais.setProfissionaisEmail(profissionaisVO.getProfissionaisEmail());
		profissionais.setProfissionalAtivo(profissionaisVO.getProfissionalAtivo());
			
		return profissionais;
	}	

}
