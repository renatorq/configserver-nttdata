package com.bootcamp.databases.repository;

import com.bootcamp.databases.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.databases.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    public Paciente findByDni(String dni);
}
