package com.aluraflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluraflix.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
	
	List<Video> findByCategoriaId(Long categoriaId);

//	Video findByTitulo(String titulo);

	List<Video> findByCategoriaTitulo(String titulo);

}
