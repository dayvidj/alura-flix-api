package com.aluraflix.dto;

import com.aluraflix.model.Video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosVideoDTO(
		@NotBlank(message = "Campo título não informado")
		String titulo,
		
		@NotBlank(message = "Campo descrição não informado")
		String descricao, 
		
		@NotBlank(message = "Campo url não informado")
		String url,
		
		@NotNull(message = "ID da categoria não informado")
		Long idCategoria) {

	public DadosVideoDTO(Video video) {
		this(video.getTitulo(), video.getDescricao(), video.getUrl(), video.getCategoria().getId());
	}
}
