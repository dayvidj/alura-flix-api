package com.aluraflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluraflix.dto.DadosAtualizacaoDTO;
import com.aluraflix.dto.DadosVideoDTO;
import com.aluraflix.exception.ValidacaoException;
import com.aluraflix.model.Video;
import com.aluraflix.repositories.CategoriaRepository;
import com.aluraflix.repositories.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional
	public void salvarVideo(DadosVideoDTO dados) {
		if (!categoriaRepository.existsById(dados.idCategoria())) {
			throw new ValidacaoException("Categoria não encontrada para o id: " + dados.idCategoria());
		}	
		 
		var categoria = categoriaRepository.getReferenceById(dados.idCategoria());
		var video = new Video(dados, categoria);
		videoRepository.save(video);
	}

	@Transactional(readOnly = true)
	public Page<DadosAtualizacaoDTO> listarVideos(Pageable paginacao) {
		var videos = videoRepository.findAll(paginacao).map(DadosAtualizacaoDTO::new);
		return videos;
	} 

	@Transactional(readOnly = true)
	public DadosVideoDTO buscarVideoPorId(Long id) {
		return videoRepository.findById(id).map(DadosVideoDTO::new).orElse(null);
	}

	@Transactional(readOnly = true)
	public Page<DadosAtualizacaoDTO> listarVideosLivre(Pageable paginacao) {
		var videos = videoRepository.findByCategoriaLivre(paginacao).map(DadosAtualizacaoDTO::new);
		return videos;
	}

	@Transactional(readOnly = true)
	public List<Video> buscarVideosPorTituloCategoria(String titulo) {
		return videoRepository.findByCategoriaTitulo(titulo);
	}

	@Transactional
	public DadosVideoDTO atualizarVideo(DadosAtualizacaoDTO dados) {
		var video = videoRepository.getReferenceById(dados.id());
		video.atualizarDados(dados);
		return new DadosVideoDTO(video);
	}

	@Transactional
	public boolean deletarVideo(Long id) {
		if (videoRepository.existsById(id)) {
			videoRepository.deleteById(id);
			return true;
		}
		return false;
	}


}
