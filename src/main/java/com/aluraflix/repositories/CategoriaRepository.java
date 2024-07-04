package com.aluraflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluraflix.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
