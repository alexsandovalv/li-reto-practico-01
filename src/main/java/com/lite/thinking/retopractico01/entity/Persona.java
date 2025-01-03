package com.lite.thinking.retopractico01.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String numeroCelular;
    private String correoElectronico;

    @ManyToOne(optional = true)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;

}
