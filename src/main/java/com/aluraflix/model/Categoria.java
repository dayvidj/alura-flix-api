package com.aluraflix.model;

import com.aluraflix.dto.DadosCadastroCategoriaDTO;
import com.aluraflix.dto.DadosCategoriaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String cor;
	
	public Categoria(DadosCadastroCategoriaDTO dados) {
		this.titulo = dados.titulo();
		this.cor = dados.cor();
	}

	public void atualizarDados(@Valid DadosCategoriaDTO dados) {
		if(dados.titulo() != null) {
			this.titulo = dados.titulo();			
		}
		if(dados.cor() != null) {
			this.cor = dados.cor();					
		}
	}

}
