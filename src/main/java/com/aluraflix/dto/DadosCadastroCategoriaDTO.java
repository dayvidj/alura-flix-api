package com.aluraflix.dto;

import com.aluraflix.model.Categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCategoriaDTO(
		@NotBlank(message = "Campo obrigatório não informado")
		String titulo, 
		@NotBlank
		@Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$", message = "Padrão de cor inválido ou não informado")
		String cor) {

	public DadosCadastroCategoriaDTO(Categoria categoria) {
		this(categoria.getTitulo(), categoria.getCor());
	}
}
