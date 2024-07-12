package com.aluraflix.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.aluraflix.dto.DadosAtualizacaoDTO;
import com.aluraflix.service.VideoService;

@SpringBootTest
@AutoConfigureMockMvc
class VideoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private VideoService videoService;
	
	@Test
	@DisplayName("Deve devolver código http 400 caso as informações forem inválidas")
	void testCadastrarCaso1() throws Exception {
		
		// Executa a requisição POST para "/videos" usando o mockMvc e obtém a resposta
		var response = mockMvc.perform(post("/videos")).andReturn().getResponse();
		
		// Verifica se o status da resposta é igual a HttpStatus.BAD_REQUEST (400)
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}

	@Test
	@DisplayName("Deve devolver código http 201 caso as informações forem válidas")
	void testCadastrarCaso2() throws Exception {
		//JSON que representa os dados a serem enviados na requisição POST
		var json = "{\"titulo\": \"Meu Vídeo\", \"descricao\": \"Descrição do vídeo\", \"url\": \"http://example.com/video\", \"idCategoria\": \"1\" }";
		
		var response = mockMvc.perform(post("/videos")
				.contentType(MediaType.APPLICATION_JSON).content(json))
				.andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}
	
//	@Test
//	@DisplayName("Deve devolver código 200 caso as informações forem válidas")
//	void testListarCaso1() throws Exception {	
//		
//		//Dados de entrada para o teste
//		List<DadosAtualizacaoDTO> videos = new ArrayList<>();
//		videos.add(new DadosAtualizacaoDTO(1l, "Video1", "Descricao video1", "video1.com", 1l));
//		videos.add(new DadosAtualizacaoDTO(2l, "Video2", "Descricao video2", "video2.com", 1l));
//		
//		Mockito.when(videoService.listarVideos()).thenReturn(videos);
//		
//		//Executa a requisição http e faz a validação da resposta esperada usando JSON
//		var response = mockMvc.perform(get("/videos")) 
//	            .andExpect(content().json("[" 
//	                + "{\"id\":1,\"titulo\":\"Video1\",\"descricao\":\"Descricao video1\",\"url\":\"video1.com\",\"idCategoria\":1},"
//	                + "{\"id\":2,\"titulo\":\"Video2\",\"descricao\":\"Descricao video2\",\"url\":\"video2.com\",\"idCategoria\":1}]"))
//	            .andReturn()
//	            .getResponse();
//		
//		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//	}

}
