package com.t2m.skills.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2m.skills.entities.Categorias;
import com.t2m.skills.repositories.CategoriasRepository;
import com.t2m.skills.vo.CategoriasVO;

@Service
public class CategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepository;
	
	public List<CategoriasVO> listar(){
		List<Categorias> categorias = categoriasRepository.findAll();
		List<CategoriasVO> listaCategoriasDTO = new ArrayList<CategoriasVO>();
		for (Categorias categoria : categorias) {
			categoria.setProfissionais(profissionaisRepository.findAllByCategoria(categoria));
			CategoriasVO categoriasVO = new CategoriasVO(categoriasRepository.save(categoria));
			categoriasVO.add(listaCategoriasDTO);
		}
		return listaCategoriasDTO;
	}
	
	public List<CategoriasVO> buscarPorNome(String nome){
		List<Categorias> categorias = categoriasRepository.findAllByNomeContaining(nome);
		List<CategoriasVO> categoriasVO = new ArrayList<CategoriasVO>();
		for (Categorias categoria : categorias) {
			categoria.setProfissionais(profissionaisRepository.findAllByCategorias(categoria));
			CategoriasVO categoriaVO = new CategoriasVO(categoria);
			categoriasVO.add(categoriaVO);
		}
		return categoriasVO;
	}
		
}
