package com.t2m.skills.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.t2m.skills.entities.Empresas;
import com.t2m.skills.repositories.EmpresasRepository;
import com.t2m.skills.vo.EmpresasVO;

@Service
public class EmpresasService {
	
	@Autowired 
	EmpresasRepository empresasRepository;
	
	public EmpresasVO findById(Long id) {
		Empresas empresas = empresasRepository.findById(id).get();
		EmpresasVO empresasVO = converteEntidadeParaVO(empresas);
		return empresasVO;
	}
	
	public List<EmpresasVO> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Empresas> listaEmpresas = null;
		List<Empresas> listaEmpresasComPaginacao = null;
		List<EmpresasVO> listaEmpresasVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listaEmpresasComPaginacao = empresasRepository.findAll(page).getContent();

				for (Empresas lEmpresas : listaEmpresasComPaginacao) {
					
					if(lEmpresas.getEmpresasAtivo()) {
						listaEmpresasVO.add(converteEntidadeParaVO(lEmpresas));
					}
					
				}

			} else {
				listaEmpresas = empresasRepository.findAll();

				for (Empresas lEmpresas : listaEmpresas) {
					if(lEmpresas.getEmpresasAtivo()) {
						listaEmpresasVO.add(converteEntidadeParaVO(lEmpresas));
					}
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de Empresas ::" + e.getMessage());
		}

		return listaEmpresasVO;
	}
	
	public EmpresasVO save(EmpresasVO empresasVO) {
		Empresas empresas = converteVOParaEntidade(empresasVO);
		empresasRepository.save(empresas);
		return converteEntidadeParaVO(empresas);
	}
	
	public EmpresasVO update(Long id, EmpresasVO empresasVO) {
		Empresas empresasNoBanco = empresasRepository.findById(id).get();
		
		if(empresasVO.getEmpresasNome() != null) {
			empresasNoBanco.setEmpresasNome(empresasVO.getEmpresasNome());
		}
		
		if(empresasVO.getEmpresasCnpj() != null) {
			empresasNoBanco.setEmpresasCnpj(empresasVO.getEmpresasCnpj());
		}
		
		if(empresasVO.getEmpresasRazaoSocial() != null) {
			empresasNoBanco.setEmpresasRazaoSocial(empresasVO.getEmpresasRazaoSocial());
		}
		
		if(empresasVO.getEmpresasNome() != null) {
			empresasNoBanco.setEmpresasNome(empresasVO.getEmpresasNome());
		}
		
		return save(converteEntidadeParaVO(empresasNoBanco));
	}
	
	public void delete(Long id) {
		Empresas empresas = empresasRepository.findById(id).get();
		empresas.setEmpresasAtivo(false);
		empresasRepository.save(empresas);
	}
	
	public Long count() {
		return empresasRepository.count();
	}
	
	public EmpresasVO converteEntidadeParaVO(Empresas empresas) {
		
		EmpresasVO empresasVO = new EmpresasVO();
		
		empresasVO.setEmpresasId(empresas.getEmpresasId());
		empresasVO.setEmpresasNome(empresas.getEmpresasNome());
		empresasVO.setEmpresasCnpj(empresas.getEmpresasCnpj());
		empresasVO.setEmpresasRazaoSocial(empresas.getEmpresasRazaoSocial());
		empresasVO.setEmpresasAtivo(empresas.getEmpresasAtivo());
			
		return empresasVO;
	}
	
	public Empresas converteVOParaEntidade(EmpresasVO empresasVO) {
		
		Empresas empresas = new Empresas();
		
		empresas.setEmpresasId(empresasVO.getEmpresasId());
		empresas.setEmpresasNome(empresasVO.getEmpresasNome());
		empresas.setEmpresasCnpj(empresasVO.getEmpresasCnpj());
		empresas.setEmpresasRazaoSocial(empresasVO.getEmpresasRazaoSocial());
		empresas.setEmpresasAtivo(empresasVO.getEmpresasAtivo());
			
		return empresas;
	}

}
