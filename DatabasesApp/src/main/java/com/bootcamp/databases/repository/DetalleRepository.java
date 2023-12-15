package com.bootcamp.databases.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bootcamp.databases.model.DetalleConsulta;

import java.util.List;

public interface DetalleRepository extends MongoRepository<DetalleConsulta, Integer> {

    void deleteByIdConsulta(Integer idConsulta);
    List<DetalleConsulta> findByIdConsulta(Integer idConsulta);

}
