package com.lite.thinking.retopractico01.repository;

import com.lite.thinking.retopractico01.entity.Estudiante;
import com.lite.thinking.retopractico01.entity.Direccion;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class RepositorioEstudiante {

    private static final Random random = new SecureRandom();
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public RepositorioEstudiante() {
        // Agregar 10 estudiantes nuevos
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Juan").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("juan@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Maria").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("maria@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Pedro").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("pedro@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Ana").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("ana@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Luis").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("luis@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Sofia").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("sofia@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Carlos").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("carlos@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Laura").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("laura@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Diego").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("diego@example.com").direccion(generarDireccionAleatoria()).build());
        estudiantes.add(Estudiante.builder().numeroEstudiante(String.format("%03d", random.nextInt(1000))).promedioNotas(Double.parseDouble(String.format("%.1f", random.nextDouble() * 100))).nombre("Isabel").numeroCelular(generarNumeroCelularAleatorio()).correoElectronico("isabel@example.com").direccion(generarDireccionAleatoria()).build());
    }

    public List<Estudiante> findAll() {
        return estudiantes;
    }


    private static final String[] paises = {"Colombia", "Estados Unidos", "México", "España", "Argentina", "Peru"};
    private static final String[] ciudades = {"Medellín", "Bogotá", "Cali", "Barranquilla", "Cartagena", "Lima Metropolitana"};
    private static final String[] estados = {"Antioquia", "Cundinamarca", "Valle del Cauca", "Atlántico", "Bolívar", "Lima"};

    private Direccion generarDireccionAleatoria() {
        return Direccion.builder()
                .direccion(UUID.randomUUID().toString().substring(0, 10))
                .ciudad(ciudades[random.nextInt(ciudades.length)])
                .estado(estados[random.nextInt(estados.length)])
                .codigoPostal(String.valueOf(random.nextInt(100000)))
                .pais(paises[random.nextInt(paises.length)])
                .build();
    }

    private String generarNumeroCelularAleatorio() {
        int longitud = 9 + random.nextInt(4); // Longitud entre 9 y 12
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            numero.append(random.nextInt(10));
        }
        return numero.toString();
    }

}
