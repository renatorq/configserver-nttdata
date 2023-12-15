package com.bootcamp.databases.service;

import com.bootcamp.databases.model.Consulta;

public interface ConsultaService {
    Consulta registrar(Consulta c) throws Exception;

    void eliminar(Integer idConsulta) throws Exception;

    Consulta obtenerConsulta(Integer idConsulta) throws Exception;

}
