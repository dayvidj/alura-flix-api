package com.aluraflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aluraflix.dto.DadosAtualizacaoDTO;
import com.aluraflix.dto.DadosVideoDTO;
import com.aluraflix.service.VideoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("videos")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosVideoDTO dados) {		
		videoService.salvarVideo(dados);	
		return ResponseEntity.status(HttpStatus.CREATED).body(dados);
	}

	@GetMapping()
	public ResponseEntity listar(@PageableDefault(size = 5) Pageable paginacao) {
		return ResponseEntity.ok(videoService.listarVideos(paginacao));
	} 

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		DadosVideoDTO video = videoService.buscarVideoPorId(id);
		if (video != null) {
			return ResponseEntity.ok(video);
		} 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video não encontrado com o ID: " + id);
	}
	
//	@GetMapping("/")
//	public ResponseEntity buscarPorTitulo(@RequestParam String search) {
//		var video = new DadosAtualizacaoDTO(videoService.buscarVideoPorTitulo(search));
//		return ResponseEntity.ok(video);
//	}
	
	@GetMapping("/search")
	public ResponseEntity buscarPorTituloCategoria(@RequestParam String nome) {
		var videos = videoService.buscarVideosPorTituloCategoria(nome).stream().map(DadosAtualizacaoDTO::new).toList();
		return ResponseEntity.ok(videos);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoDTO dados) {
		var videoAtualizado = videoService.atualizarVideo(dados);
		return ResponseEntity.ok(videoAtualizado);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletar(@PathVariable Long id) {
		if(videoService.deletarVideo(id)) {
			return ResponseEntity.ok("Vídeo deletado com sucesso.");			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vídeo não encontrado.");
	}

}
