package com.bootcamp.databases.repository;

import com.bootcamp.databases.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta,Integer> {
}
