package com.aluraflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluraflix.dto.DadosCadastroCategoriaDTO;
import com.aluraflix.dto.DadosCategoriaDTO;
import com.aluraflix.model.Categoria;
import com.aluraflix.model.Video;
import com.aluraflix.repositories.CategoriaRepository;
import com.aluraflix.repositories.VideoRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private VideoRepository videoRepository;
	
	@Transactional
	public Categoria salvarCategoria(DadosCadastroCategoriaDTO dados) {
		var categoria = new Categoria(dados);
		return categoriaRepository.save(categoria);
	}
	
	@Transactional(readOnly = true)
	public List<DadosCategoriaDTO> listarCategorias(){
		var categorias = categoriaRepository.findAll().stream().map(DadosCategoriaDTO::new).toList();
		return categorias;
	}
	
	@Transactional(readOnly = true)
	public DadosCategoriaDTO buscarCategoriaPorId(Long id) {
		return categoriaRepository.findById(id).map(DadosCategoriaDTO::new).get();
	}
	
	@Transactional(readOnly = true)
	public List<Video> buscarVideosPorCategoria(Long categoriaId) {
		List<Video> videos = videoRepository.findByCategoriaId(categoriaId);
		return videos;
	}
	
	@Transactional
	public DadosCadastroCategoriaDTO atualizarCategoria(DadosCategoriaDTO dados) {
		var categoria = categoriaRepository.getReferenceById(dados.id());
		categoria.atualizarDados(dados);
		return new DadosCadastroCategoriaDTO(categoria);
	}
	
	@Transactional
	public boolean deletarCategoria(Long id) {
		if(categoriaRepository.existsById(id)) {
			categoriaRepository.deleteById(id);	
			return true;
		}
		return false;
	}

}
