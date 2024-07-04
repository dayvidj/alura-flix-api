package com.aluraflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.aluraflix.dto.DadosAtualizacaoDTO;
import com.aluraflix.dto.DadosCadastroCategoriaDTO;
import com.aluraflix.dto.DadosCategoriaDTO;
import com.aluraflix.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoriaDTO dados) {
		categoriaService.salvarCategoria(dados);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dados);
	}
	
	@GetMapping
	public ResponseEntity listar() {
		return ResponseEntity.ok(categoriaService.listarCategorias());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarCategoria(@PathVariable Long id) {
		var dadosCategoria = categoriaService.buscarCategoriaPorId(id);
		return ResponseEntity.ok(dadosCategoria);
	}
	
	@GetMapping("/{idCategoria}/videos")
	public ResponseEntity buscarVideosPorCategoria(@PathVariable Long idCategoria) {
		var videosPorCategoria = categoriaService.buscarVideosPorCategoria(idCategoria).stream().map(DadosAtualizacaoDTO::new).toList();
		return ResponseEntity.ok(videosPorCategoria);
	}
		
	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosCategoriaDTO dados) {
		var categoria = categoriaService.atualizarCategoria(dados);
		return ResponseEntity.ok(categoria);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletar(@PathVariable Long id) {
		if(categoriaService.deletarCategoria(id)){
			return ResponseEntity.ok("Categoria deletada com sucesso.");			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
	}
	
}
