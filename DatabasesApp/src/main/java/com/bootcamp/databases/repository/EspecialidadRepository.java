package com.bootcamp.databases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.databases.model.Especialidad;

import java.util.List;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {

}
