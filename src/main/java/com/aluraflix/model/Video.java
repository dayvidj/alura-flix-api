package com.aluraflix.model;

import com.aluraflix.dto.DadosAtualizacaoDTO;
import com.aluraflix.dto.DadosVideoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "videos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	
	public Video(DadosVideoDTO dados) {
		this.titulo = dados.titulo();
		this.descricao = dados.descricao();
		this.url = dados.url();
	}

	public void atualizarDados(DadosAtualizacaoDTO dados) {
		if(dados.titulo() != null) {
			this.titulo = dados.titulo();
		}
		if(dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if(dados.url() != null) {
			this.url = dados.url();
		}
	}
	
}
