package com.bootcamp.databases.service;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.model.Paciente;

import java.util.List;

public interface ExamenService {

    void registrar(Examen examen) throws Exception;

    void modificar(Examen examen) throws Exception;

    Examen buscar(Integer id) throws Exception;

    List<Examen> listarTodos() throws Exception;

    void eliminar(Integer id) throws Exception;

}
