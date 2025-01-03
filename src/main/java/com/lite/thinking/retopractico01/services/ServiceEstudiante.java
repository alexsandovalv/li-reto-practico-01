package com.lite.thinking.retopractico01.services;

import com.lite.thinking.retopractico01.entity.Estudiante;
import com.lite.thinking.retopractico01.repository.RepositorioEstudiante;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ServiceEstudiante {

    private final RepositorioEstudiante repositorioEstudiante;

    public ServiceEstudiante(RepositorioEstudiante repositorioEstudiante) {
        this.repositorioEstudiante = repositorioEstudiante;
    }

    public List<Estudiante> listarEstudiantes(){
        return repositorioEstudiante.findAll();
    }

    public List<Estudiante> filtrarPorNombre(String nombre) {
        return repositorioEstudiante.findAll().stream()
                .filter(estudiante -> estudiante.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    public List<Estudiante> filtrarPorNumeroCelular(String numeroCelular) {
        return repositorioEstudiante.findAll().stream()
                .filter(estudiante -> estudiante.getNumeroCelular().equals(numeroCelular))
                .collect(Collectors.toList());
    }

    public List<Estudiante> ordenarPorPromedioNotas(boolean asc) {
        Comparator<Estudiante> comparator = Comparator.comparingDouble(Estudiante::getPromedioNotas);
        if (!asc)
            comparator = comparator.reversed();

        return repositorioEstudiante.findAll().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
