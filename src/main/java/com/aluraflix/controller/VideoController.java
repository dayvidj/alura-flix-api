package com.aluraflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.aluraflix.dto.DadosAtualizacaoDTO;
import com.aluraflix.dto.DadosVideoDTO;
import com.aluraflix.model.Video;
import com.aluraflix.repositories.VideoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("videos")
public class VideoController {

	@Autowired
	private VideoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DadosVideoDTO dados) {
		var video = new Video(dados);
		repository.save(video);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dados);
	}

	@GetMapping
	public ResponseEntity listar() {
		var videos = repository.findAll().stream().map(DadosAtualizacaoDTO::new).toList();
		return ResponseEntity.ok(videos);
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		var video = repository.findById(id);
		if (video.isPresent()) {
			return ResponseEntity.ok(new DadosVideoDTO(video.get()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado com o ID: " + id);
		}
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoDTO dados) {
		var video = repository.getReferenceById(dados.id());
		video.atualizarDados(dados);
		return ResponseEntity.ok(new DadosVideoDTO(video));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> deletar(@PathVariable Long id) {
	    if (repository.existsById(id)) {
	        repository.deleteById(id);
	        return ResponseEntity.ok("Vídeo deletado com sucesso.");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vídeo não encontrado.");
	    }
	}

}
