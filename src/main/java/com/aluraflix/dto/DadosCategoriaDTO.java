package com.aluraflix.dto;

import com.aluraflix.model.Categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCategoriaDTO(
		@NotNull
		Long id,
		String titulo, 
		String cor) {
	
	public DadosCategoriaDTO(Categoria categoria) {
		this(categoria.getId(), categoria.getTitulo(), categoria.getCor());
	}
}
