package com.lite.thinking.retopractico01.controller;

import com.lite.thinking.retopractico01.entity.Estudiante;
import com.lite.thinking.retopractico01.services.ServiceEstudiante;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final ServiceEstudiante serviceEstudiante;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        return ResponseEntity.ok(serviceEstudiante.listarEstudiantes());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Estudiante>> listarEstudiantesPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(serviceEstudiante.filtrarPorNombre(nombre));
    }

    @GetMapping("/celular/{celular}")
    public ResponseEntity<List<Estudiante>> listarEstudiantesPorNumeroCelular(@PathVariable String celular) {
        return ResponseEntity.ok(serviceEstudiante.filtrarPorNumeroCelular(celular));
    }

    @GetMapping({"/ordenarPromedioNotas/{ascendente}", "/ordenarPromedioNotas"})
    public ResponseEntity<List<Estudiante>> listarEstudiantesPorPromedioNotas(@PathVariable(required = false) boolean ascendente) {
        return ResponseEntity.ok(serviceEstudiante.ordenarPorPromedioNotas(ascendente));
    }

}
