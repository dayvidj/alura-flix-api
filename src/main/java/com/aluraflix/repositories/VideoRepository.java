package com.aluraflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluraflix.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
