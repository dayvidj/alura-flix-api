package com.aluraflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aluraflix.dto.DadosAtualizacaoDTO;
import com.aluraflix.dto.DadosVideoDTO;
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
	public Video salvarVideo(DadosVideoDTO dados) {
		if (!categoriaRepository.findById(dados.idCategoria()).isPresent()) {
			throw new IllegalArgumentException("Categoria não encontrada para o id: " + dados.idCategoria());
		}

		var categoria = categoriaRepository.getReferenceById(dados.idCategoria());
		var video = new Video(dados, categoria);
		return videoRepository.save(video);
	}

	@Transactional(readOnly = true)
	public List<DadosAtualizacaoDTO> listarVideos() {
		var videos = videoRepository.findAll().stream().map(DadosAtualizacaoDTO::new).toList();
		return videos;
	}

	@Transactional(readOnly = true)
	public DadosVideoDTO buscarVideoPorId(Long id) {
		return videoRepository.findById(id).map(DadosVideoDTO::new).orElse(null);
	}

//	@Transactional(readOnly = true)
//	public Video buscarVideoPorTitulo(String titulo) {
//		return videoRepository.findByTitulo(titulo);
//	}

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
