package com.aluraflix.dto;

import com.aluraflix.model.Video;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDTO(
		@NotNull
		Long id,  			
		String titulo, 
		String descricao, 
		String url) {
	
	public DadosAtualizacaoDTO(Video video) {
		this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
	}
}
