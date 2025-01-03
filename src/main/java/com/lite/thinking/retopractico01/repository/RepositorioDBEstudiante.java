package com.lite.thinking.retopractico01.repository;

import com.lite.thinking.retopractico01.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDBEstudiante extends JpaRepository<Estudiante, Long> {
}
