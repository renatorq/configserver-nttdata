package com.bootcamp.databases.repository;

import com.bootcamp.databases.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<Examen,Integer> {

    Examen findByNombre(String nombreExamen);

}
