package com.bootcamp.databases.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false, foreignKey = @ForeignKey(name = "fkConsultaMedico"))
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad", nullable = false, foreignKey = @ForeignKey(name = "fkConsultaEspecialidad"))
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = true, foreignKey = @ForeignKey(name = "fkConsultaPaciente"))
    private Paciente paciente;

    @ManyToMany
    @JoinTable(
            name = "consulta_examen",
            joinColumns = @JoinColumn(name = "id_consulta"),
            inverseJoinColumns = @JoinColumn(name = "id_examen")
    )
    private List<Examen> examenes = new ArrayList<>();

    @Transient
    private List<DetalleConsulta> detallesConsulta;

}
