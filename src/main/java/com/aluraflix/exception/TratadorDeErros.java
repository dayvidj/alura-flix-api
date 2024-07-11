package com.aluraflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity tratarErro404() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Falha: Não encontrado");
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity tratarErro400() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parâmetro inválido");
	}

	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity tratarErroRegraDeNegocio(ValidacaoException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
	}
	
	private record DadosErroValidacao(String campo, String mensagem) {
		
		public DadosErroValidacao(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
 	
}
