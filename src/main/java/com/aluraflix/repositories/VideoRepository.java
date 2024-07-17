package com.aluraflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aluraflix.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
	
	List<Video> findByCategoriaId(Long categoriaId);

	List<Video> findByCategoriaTitulo(String titulo);

	@Query("SELECT v FROM Video v WHERE v.categoria.titulo = 'Livre'")
	Page<Video> findByCategoriaLivre(Pageable paginacao);

}
