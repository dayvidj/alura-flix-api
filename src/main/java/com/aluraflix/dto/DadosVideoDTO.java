package com.aluraflix.dto;

import com.aluraflix.model.Video;

import jakarta.validation.constraints.NotBlank;

public record DadosVideoDTO(
		@NotBlank(message = "Campo não informado")
		String titulo, 
		@NotBlank(message = "Campo não informado")
		String descricao, 
		@NotBlank(message = "Campo não informado")
		String url) {

	public DadosVideoDTO(Video video) {
		this(video.getTitulo(), video.getDescricao(), video.getUrl());
	}
}
