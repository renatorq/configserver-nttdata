package com.bootcamp.databases.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExamen;
    @Column(name = "nombre", length = 100)
    private String nombre;
    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @ManyToMany(mappedBy = "examenes")
    private List<Consulta> consultas = new ArrayList<>();


}
