package com.aluraflix.dto;

import com.aluraflix.model.Video;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDTO(
		@NotNull(message = "ID não pode ser nulo")
		Long id,  			
		String titulo, 
		String descricao, 
		String url,
		Long idCategoria) { 
	
	public DadosAtualizacaoDTO(Video video) {
		this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl(), video.getCategoria().getId());
	}
}
